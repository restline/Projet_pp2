package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controleur.Ville;

public class ModeleVille 
{
	public static ArrayList<Ville> selectAll()
	{
		ArrayList<Ville> lesVilles = new ArrayList<Ville>();
		
		String requete = "select * from ville";
		
		try
		{
			BDD uneBDD = new BDD("mysql.hostinger.fr", "u587264972_rest", "u587264972_rest", "ProjetPPE_1/"); //instation d'une nouvelle connexion
			
			uneBDD.seConnecter(); //connexion
			
			Statement uneStat = uneBDD.getMaconnexion().createStatement(); //instance connexion
			
			ResultSet unRes = uneStat.executeQuery(requete); //exécution requête
			
			while(unRes.next())
			{
				int cpVille = unRes.getInt("cpVille");
				String nomVille = unRes.getString("nomVille");
				int idRegion = unRes.getInt("idRegion");
				
				//instation classe restaurant
				
				Ville uneVille = new Ville(cpVille, nomVille, idRegion);
				
				lesVilles.add(uneVille); //ajout données table restaurant
			}
			
			
			
			unRes.close();
			uneStat.close();
			uneBDD.seDeconnecter();
			
		}
		catch(SQLException exp) //gestion erreurs SQL
		{
			System.out.println("Erreur de la connexion " + requete);
		}
		
		return lesVilles;
	}
	public static void supprimmer(int cpVille)
	{
		String requete = "delete from ville where cpVille=" + cpVille;
		
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
			System.out.println("Suppresion de la ville réussit : " + requete);
		}
	}
	public static void inserer(Ville uneVille)
	{
		String requete = "insert into ville(cpVille, nomVille, idRegion) "
						 + "values ('" + uneVille.getCpVille() + "','" + uneVille.getNomVille() + "','"
						 + uneVille.getIdRegion() + "');";
		
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
			System.out.println("Insertion de la ville réussite : " + requete);
		}
						 
	}
	
	public static void MJ(int cpVille, String nomVille, int idRegion)
	{
		String requete = "update ville set nomVille='" + nomVille +  "', idRegion=" + idRegion
						 + " where cpVille=" + cpVille;
		
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
			System.out.println("Mise à jour de la ville réussit : " + requete);
		}
	}
	
}
