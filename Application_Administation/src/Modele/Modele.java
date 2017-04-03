package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controleur.Profil;
import Modele.BDD;

public class Modele {
	public static ArrayList<Profil> selectAll()
	{
		//methode qui va extraite toute les occurences de la table produit, instancie la classe produit
		//et retourne les produits dans le arraylist
		ArrayList<Profil> lesProfil = new ArrayList<Profil>();
		String requete ="select * from user";
		
		try
		{
			BDD uneBDD = new BDD("localhost", "restline", "root", "");
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaconnexion().createStatement(); //créer une instance connexion
			ResultSet unRes = unStat.executeQuery(requete); //éxécute requête
			while(unRes.next())
			{
				//récupération données
				String email = unRes.getString("email");
				String nom = unRes.getString("nom");
				String prenom = unRes.getString("prenom");
				String mdp = unRes.getString("mdp");
				boolean permission = unRes.getBoolean("permission");
				
				
				
				//instation de la classe produit
				Profil unProfil = new Profil(email, nom, prenom, mdp, permission);
				
				//insertion du produit dans le ArrayList
				lesProfil.add(unProfil);
				
				
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) //gestion erreurs SQL
		{
			System.out.println("Erreur de la connexion" + requete);
		}
		
		return lesProfil;
	}
	
	public static void insert(Profil unProfil) //methode inserer
	{
		String requete = "insert into user (email, nom, prenom, mdp, " 
		+ "permission) values('"+unProfil.getEmail()+"','"
		+ unProfil.getNom()+"'," +unProfil.getPrenom()+","+unProfil.getMdp()+","+unProfil.isPermission()+");";
		
		try
		{
			BDD uneBDD = new BDD("localhost", "restline", "root", "");
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
	
	public static void delete(int idUser) //methode supprimer
	{
		String requete = "Delete from user where  = '" + idUser +"';";
		
		try
		{
			BDD uneBDD = new BDD("localhost", "restline", "root", "");
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
	public static Profil selectWhere(String email,  String Mdp)
	{
		String requete = "select * "
						+"from user "
						+"where email = '"+ email + "' "
						+"and mdp = '" + Mdp + "'";
		Profil unProfil = null;
		try
		{
			BDD uneBDD = new BDD("localhost", "restline", "root", "");
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				
				String login = unRes.getString("email");
				String Nom = unRes.getString("nom");
				String Prenom = unRes.getString("prenom");
				String mdp = unRes.getString("Mdp");
				boolean Permission = unRes.getBoolean("permission");
				
			    unProfil = new Profil(login, mdp, Nom, Prenom,Permission);
			}
			unStat.close();
			uneBDD.seDeconnecter();
			unRes.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : " + requete);
		}
		
		return unProfil;
	}
}
