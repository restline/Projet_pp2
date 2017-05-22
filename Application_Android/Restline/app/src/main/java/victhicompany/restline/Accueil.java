package victhicompany.restline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;

public class Accueil extends AppCompatActivity implements View.OnClickListener{

    private Button uneResa;
    private String idRes, idClt, nomClt;
    private TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //association de l'id du boutton à l'attribut uneResa
        this.uneResa = (Button) findViewById(R.id.idRes);

        //récupération des donnée SQL envoyée à la connexion
        this.idClt = getIntent().getStringExtra("idClient");
        this.nomClt = getIntent().getStringExtra("nomClient");

        //association de l'id du textView à l'attribut message
        this.message = (TextView) findViewById(R.id.idMessage);
        //éxécution d'un text sur le TextView
        message.setText("Espace Client");

        //Bouton cliquable
        this.uneResa.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
       switch (v.getId())
       {
           case R.id.idRes :
               Thread unT = new Thread(new Runnable() {
                   @Override
                   public void run() {
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {

                                    //passage de la fenêtre acceuil à la fenêtre Menu
                                    Intent unIntent = new Intent(Accueil.this, Menu.class);
                                    //envoie de l'id du client de la connexion à la fenêtre Menu
                                    unIntent.putExtra("idClient", idClt);
                                    //Début de l'ouverture
                                    startActivity(unIntent);

                           }
                       });
                   }
               });
               unT.start();
               break;
       }

    }
}
