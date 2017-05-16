package Modele;

//importation librairie
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//inclusion du controleur
import Controleur.Client;
import Modele.BDD;

public class ModeleClient
{
	public static ArrayList<Client> selectAll() //création méthode selectAll()
	{
		//methode qui va extraite toute les occurences de la table client, instancie la classe client
		//et retourne les clients dans le arraylist
		ArrayList<Client> lesClient = new ArrayList<Client>();
		String requete ="select * from client";
		
		try
		{
			BDD uneBDD = new BDD("localhost", "restline", "root", "");
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaconnexion().createStatement(); //créer une instance connexion
			ResultSet unRes = unStat.executeQuery(requete); //éxécute requête
			while(unRes.next())
			{
				//récupération données
				int idClient = unRes.getInt("idClient");
				String emailClient = unRes.getString("emailClient");
				String nomClient = unRes.getString("nomClient");
				String numTelClient = unRes.getString("numTelClient");
				String mdpClient = unRes.getString("mdpClient");
				String cp = unRes.getString("cp");
				String rue = unRes.getString("rue");
				String ville = unRes.getString("ville");
				
				
				
				//instation de la classe client
				Client unClient = new Client(idClient, nomClient, 
											 emailClient, numTelClient, 
											 cp, rue, ville, mdpClient);
				
				//insertion du produit dans le ArrayList
				lesClient.add(unClient);
				
				
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) //gestion erreurs SQL
		{
			System.out.println("Erreur de la connexion" + requete);
		}
		
		return lesClient;
	}
	
}
