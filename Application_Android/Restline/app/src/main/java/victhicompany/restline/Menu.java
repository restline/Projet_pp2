package victhicompany.restline;

import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Menu extends AppCompatActivity {

    private static String idClient;
    private ListView lvListe;

    private static ArrayList<String> lesReservations = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //recupération de l'id du client envoyé à la connexion, équivalent à un $_SESSION en PHP
        idClient = getIntent().getStringExtra("idClient");
        //association de l'id du listView à l'attribut lvListe ListView
        this.lvListe = (ListView) findViewById(R.id.idList);

        //création d'un processus fils pour l'éxécution de la tâche asynchrone
        Thread unTH = new Thread(new Runnable() {
            @Override
            public void run() {
                //instantation de la classe ConnexionCMD
                final ConnexionCMD uneConnexion = new ConnexionCMD();

                runOnUiThread(new Runnable() {
                                  @Override
                                  public void run() {
                                      //éxécution d'une connexion pour récupérer l'id en paramètre
                                      uneConnexion.execute(idClient);
                                      //instation d'un array
                                      ArrayAdapter unAdapter = new ArrayAdapter(Menu.this,android.R.layout.simple_list_item_1, android.R.id.text1, lesReservations)
                                      {
                                          //méthode unique pour effectuer des changements sur le ListView
                                          @Override
                                          public View getView(int position, View convertView, ViewGroup parent){

                                              View view = super.getView(position, convertView, parent); //création du view et héritage du getview

                                              TextView ListItemShow = (TextView) view.findViewById(android.R.id.text1); //création du textview en l'associant au view

                                              ListItemShow.setTextColor(Color.parseColor("#FFFFFF")); //définition de la couleur du text dans le ListView
                                              ListItemShow.setGravity(Gravity.CENTER); //centrer le texte dans le listView

                                              return view;
                                          }
                                      };
                                      //éxécution des données dans le listeView
                                      lvListe.setAdapter(unAdapter);
                                  }
                              }

                );

            }
        });
        unTH.start();


    }

    public static void setLesReservations(ArrayList<String> setLesResevations)
    {
        Menu.lesReservations = setLesResevations;
    }

}

//application de la AsynTash pour les réservations

class ConnexionCMD extends AsyncTask<String, Void, ArrayList<String>> /* <entree, en cour d'execution, sortie>*/
{
    @Override
    protected ArrayList<String> doInBackground(String... params) /* éxécuter en arrière plan */
    {
        String url = "http://restline.esy.es/Android_json/mesReservation.php";
        String idClient = params[0];
        InputStream is = null;
        OutputStream os = null;
        String resultat = "";
        ArrayList<String> lesReser = new ArrayList<String>();
        try
        {
            URL uneurl = new URL(url);
            //creation connexion http
            HttpURLConnection maConnexion = (HttpURLConnection)uneurl.openConnection();
            //on fixe la methode d'envoi /reception de la methode
            maConnexion.setRequestMethod("GET");
            //on fixe le temps de connexion de reponse
            maConnexion.setReadTimeout(1000); //en ms
            maConnexion.setConnectTimeout(5000); //en ms
            //on fixe la possibilité d'envoi et réception des données
            maConnexion.setDoInput(true);
            maConnexion.setDoOutput(true);
            // encapsulation des données
            Uri.Builder ub = new Uri.Builder();
            ub.appendQueryParameter("idClient", idClient);

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
            maConnexion.connect();
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
            for(int i = 0; i<tabJson.length(); i++)
            {

                JSONObject unJson = tabJson.getJSONObject(i);
                //attribution des données SQL à la variable Reser sous forme JSON
                String Reserv = unJson.getString("date_heure_Reservation")+" - "+unJson.getInt("nbPersonnes")+" - "+unJson.getString("statut");
                //ajout dans l'arrayList lesReserv
                lesReser.add(Reserv);

            }



        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return lesReser;
    }
    //après éxecution de la tache, récupération du résultat
    @Override
    public void onPostExecute (ArrayList<String> lesResas)
    {
        Menu.setLesReservations(lesResas);
    }


}