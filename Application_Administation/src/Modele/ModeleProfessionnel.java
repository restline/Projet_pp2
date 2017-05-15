package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controleur.Professionnel;

public class ModeleProfessionnel 
{
	public static ArrayList<Professionnel> selectAll() //création méthode selectAll()
	{
		//methode qui va extraite toute les occurences de la table client, instancie la classe client
		//et retourne les clients dans le arraylist
		ArrayList<Professionnel> lesClient = new ArrayList<Professionnel>();
		String requete ="select * from professionnel";
		
		try
		{
			BDD uneBDD = new BDD("mysql.hostinger.fr", "u587264972_rest", "u587264972_rest", "ProjetPPE_1/");
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaconnexion().createStatement(); //créer une instance connexion
			ResultSet unRes = unStat.executeQuery(requete); //éxécute requête
			while(unRes.next())
			{
				int idClient = unRes.getInt("idClient");
				String emailClient = unRes.getString("emailClient");
				String nomClient = unRes.getString("nomClient");
				String numTelClient = unRes.getString("numTelClient");
				String cp = unRes.getString("cp");
				String rue = unRes.getString("rue");
				String ville = unRes.getString("ville");
				String mdpClient = unRes.getString("mdpClient");
				String numSiret = unRes.getString("numSiret");
				String nomContact = unRes.getString("nomContact");
				String prenomContact = unRes.getString("prenomContact");
				
				Professionnel unClient = new Professionnel(idClient, nomClient, emailClient, numTelClient,
														   cp , rue, ville, mdpClient, numSiret, nomContact,
														   prenomContact);
				lesClient.add(unClient);
			}
		
		}
		catch(SQLException exp) //gestion erreurs SQL
		{
			System.out.println("Erreur d'affichage" + requete);
		}
		
		return lesClient;
	}
	
	public static void insert(Professionnel unProfessionel)
	{
		String requete = "insert into professionnel(nomClient, emailClient, numTelClient, cp, rue, ville,"
						+"mdpClient, numSiret, nomContact, prenomContact) values ('" + unProfessionel.getNomClient() 
						+ "', '" +  unProfessionel.getEmailClient() + "', '" + unProfessionel.getNumTelClient() 
						+ "', '" + unProfessionel.getCp() + "', '" + unProfessionel.getRue() + "', '" + unProfessionel.getVille()
						+ "', '" + unProfessionel.getNumSiret() + "', '" + unProfessionel.getNomContact()
						+ "', '" + unProfessionel.getPrenomContact() + "');";
		
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
			System.out.println("Erreur de l'insertion du Professionnel : " + requete);
		}
	}
	
	public static void update(String nomClient, String emailClient, String numTelClient, String cp,
							  String rue, String ville, String mdpClient, String numSiret, String nomContact,
							  String prenomContact)
	{
		String requete = "update professionnel" 
				+ " set nomClient ='"+ nomClient + "', emailClient ='" + emailClient
				+ "', numTelClient ='" + numTelClient + "', cp ='" + cp + "', rue = '"
				+ rue + "', ville ='" + ville + "', mdpClient = '" + mdpClient
				+ "', numSiret ='" + numSiret + "', nomContact ='" + nomContact + "', prenomContact ='"
				+ prenomContact + "' where nomClient = '" + nomClient + "';";
		
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
			System.out.println("Erreur de la mise à jour du professionnel : " + requete);
		}
	}
	
	public static void delete(String nomC)
	{
		String requete = "delete from professionnel where nomClient ='" + nomC + "';";
		
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
			System.out.println("Erreur de la Supression du professionnel : " + requete);
		}
	}
}
