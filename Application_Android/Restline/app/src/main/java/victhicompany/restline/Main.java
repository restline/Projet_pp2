package victhicompany.restline;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main extends AppCompatActivity implements View.OnClickListener{

    private ImageView uneImage ;
    private EditText txtLogin, txtMdp;
    private Button btAnnuler, btSeConnecter;
    private ProgressBar unprogressBar;
    private CheckBox cbSave;
    private static  Profil profilConnect = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.txtLogin = (EditText) findViewById(R.id.idLogin);
        this.txtMdp = (EditText) findViewById(R.id.idMdp);


        this.unprogressBar = (ProgressBar) findViewById(R.id.progressBar);

        this.btAnnuler = (Button) findViewById(R.id.idAnnuler);
        this.btSeConnecter = (Button)  findViewById(R.id.idSeConnecter);


        this.cbSave = (CheckBox) findViewById(R.id.idCheckLogin);

        this.btAnnuler.setOnClickListener(this);
        this.btSeConnecter.setOnClickListener(this);
        this.unprogressBar.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.idAnnuler :
                this.txtLogin.setText("");
                this.txtMdp.setText("");
                this.unprogressBar.setVisibility(View.INVISIBLE);
                break;
            case R.id.idSeConnecter :
                String Login = this.txtLogin.getText().toString();
                String mdp = this.txtMdp.getText().toString();

                if(Login.equals("") || mdp.equals(""))
                {
                    Toast.makeText(this, "Veuilliez remplir les identifiants", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Verification en cours : " + Login , Toast.LENGTH_LONG).show();
                    this.unprogressBar.setVisibility(View.VISIBLE);
                    //connexion à l'url
                    final Profil unProfil = new Profil(0,"", Login,"", "", "", "", mdp);
                    //création d'un processus fils pour l'éxécution de la tâche asynchrone
                    Thread unT = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                //instantation de la classe connexion
                           final  Connexion uneConnexion = new Connexion();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //éxécution de la tache
                                    uneConnexion.execute(unProfil);
                                    if(profilConnect == null)
                                    {
                                        Toast.makeText(Main.this,"Veuiliez vérifier vos identifiants", Toast.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(Main.this,"Bienvenue " + " " + profilConnect.getNomClient(),
                                                Toast.LENGTH_LONG).show();

                                        Intent unIntent = new Intent(Main.this, Accueil.class); //ouvre une nouvelle fenêtre
                                        unIntent.putExtra("emailClient", profilConnect.getEmailClient()); //équivalant $_POST
                                        unIntent.putExtra("idClient", profilConnect.getIdClient()+""); //équivalant $_POST
                                        unIntent.putExtra("nomClient", profilConnect.getNomClient());
                                        startActivity(unIntent);
                                    }
                                }
                            });


                        }
                    });
                    //lancement du processus
                    unT.start();

                }
                break;
        }
    }
    public static void setProfil (Profil unProfil)
    {
        profilConnect = unProfil;
    }
}

/*****************************************************************************************************/
class Connexion extends AsyncTask<Profil, Void, Profil> /* <entree, en cour d'execution, sortie>*/
{
    @Override
    protected Profil doInBackground(Profil... params) /* éxécuter en arrière plan */
    {
        Profil unProfil = params[0];
        String url = "http://restline.esy.es/Android_json/VerifConnexions.php";
        InputStream is = null;
        OutputStream os = null;
        String resultat = "";
        Profil profilResultat = null; //profil resultat à retourner
        try
        {
            URL uneurl = new URL(url);
            //creation connexion http
            HttpURLConnection maConnexion = (HttpURLConnection)uneurl.openConnection();
            //on fixe la methode d'envoi /reception de la methode
            maConnexion.setRequestMethod("GET");
            //on fixe le temps de connexion de reponse
            maConnexion.setReadTimeout(10000); //en ms
            maConnexion.setConnectTimeout(25000); //en ms
            //on fixe la possibilité d'envoi et réception des données
            maConnexion.setDoInput(true);
            maConnexion.setDoOutput(true);
            // encapsulation des données
            Uri.Builder ub = new Uri.Builder();
            ub.appendQueryParameter("emailClient", unProfil.getEmailClient());
            ub.appendQueryParameter("mdpClient", unProfil.getMdpClient());

            String parametres = ub.build().getEncodedQuery();
            Log.e("parametres : ", parametres);
            maConnexion.connect();
            //ecriture dans le buffer d'envoi des parametres
            os = maConnexion.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8")); // buffer zone memoire tampon
            bw.write(parametres);
            bw.flush();
            bw.close();
            os.close();
            //etablissement de la connexion

            //lecture de la reponse dans le buffer de lecture
            is = maConnexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //on definit une chaine de string pour lire toute les lignes du buffer
            StringBuilder sb = new StringBuilder();
            String ligne = "";
            while((ligne = br.readLine())!= null)
            {
                sb.append(ligne); //lecture ligne par ligne
            }
            is.close();
            br.close();

            resultat = sb.toString(); //recuperer le tout dans la chaine resultat
            //on affiche le resultat en log
            Log.e("resultat :", resultat );

        }
        catch(IOException exp)
        {
            exp.printStackTrace();

        }
        try
        {
            //traitement du resultat et extraction du json
            JSONArray tabJson = new JSONArray(resultat);
            JSONObject unJson = tabJson.getJSONObject(0);
            int nb = unJson.getInt("nb");

            if(nb != 0)
            {
                int idClient = unJson.getInt("idClient");
                String nomClient = unJson.getString("nomClient");
                String numTelClient = unJson.getString("numTelClient");
                String cp = unJson.getString("cp");
                String rue = unJson.getString("rue");
                String ville = unJson.getString("ville");

                profilResultat = new Profil(idClient, nomClient, unProfil.getEmailClient(), numTelClient, cp, rue, ville, unProfil.getMdpClient());
                Log.e("nom", nomClient);
            }



        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return profilResultat;
    }
    //après éxecution de la tache, récupération du résultat
    @Override
    public void onPostExecute (Profil unprofil)
    {
        Main.setProfil(unprofil);
    }
}
