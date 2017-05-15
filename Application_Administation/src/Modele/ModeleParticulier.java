package Modele;

//importation librairie
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//inclusion du controleur
import Controleur.Particulier;
import Modele.BDD;

public class ModeleParticulier
{
	public static ArrayList<Particulier> selectAll() //création méthode selectAll()
	{
		//methode qui va extraite toute les occurences de la table client, instancie la classe client
		//et retourne les clients dans le arraylist
		ArrayList<Particulier> lesClient = new ArrayList<Particulier>();
		String requete ="select * from particulier";
		
		try
		{
			BDD uneBDD = new BDD("mysql.hostinger.fr", "u587264972_rest", "u587264972_rest", "ProjetPPE_1/");
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
				String cp = unRes.getString("cp");
				String rue = unRes.getString("rue");
				String ville = unRes.getString("ville");
				String mdpClient = unRes.getString("mdpClient");
				String prenom = unRes.getString("prenom");
				
				
				
				//instation de la classe particulier
				Particulier unClient = new Particulier(idClient, nomClient, 
											 emailClient, numTelClient, 
											 cp, rue, ville, mdpClient, prenom);
				
				//insertion du produit dans le ArrayList
				lesClient.add(unClient);
				
				
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) //gestion erreurs SQL
		{
			System.out.println("Erreur d'affichage" + requete);
		}
		
		return lesClient;
	}
	
	public static void delete(String nomClient)
	{
		String requete = "delete from particulier where nomClient ='" + nomClient + "';";
		
		try
		{
			BDD uneBDD = new BDD("mysql.hostinger.fr", "u587264972_rest", "u587264972_rest", "ProjetPPE_1/");
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaconnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : " + requete);
		}
	}
	
	public static void update(String nomClient, String emailClient, String numTelClient, String cp,
							  String rue, String ville, String mdpClient, String prenom)
	{
		String requete = "update particulier"
				+ " set nomClient ='"+ nomClient + "', emailClient ='" + emailClient
				+ "', numTelClient ='" + numTelClient + "', cp ='" + cp + "', rue = '"
				+ rue + "', ville ='" + ville + "', mdpClient = '" + mdpClient
				+ "', prenom ='" + prenom + "' where nomClient = '" + nomClient + "';";
		
		
		try
		{
			BDD uneBDD = new BDD("mysql.hostinger.fr", "u587264972_rest", "u587264972_rest", "ProjetPPE_1/");
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaconnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de l'insertion du particulier : " + requete);
		}
	}
}
