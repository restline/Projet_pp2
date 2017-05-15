package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controleur.Region;


public class ModeleRegion 
{
	public static ArrayList<Region> selectAll()
	{
		ArrayList<Region> lesRegions = new ArrayList<Region>();
		
		String requete = "select * from region";
		
		try
		{
			BDD uneBDD = new BDD("mysql.hostinger.fr", "u587264972_rest", "u587264972_rest", "ProjetPPE_1/"); //instation d'une nouvelle connexion
			
			uneBDD.seConnecter(); //connexion
			
			Statement uneStat = uneBDD.getMaconnexion().createStatement(); //instance connexion
			
			ResultSet unRes = uneStat.executeQuery(requete); //exécution requête
			
			while(unRes.next())
			{
				int idRegion = unRes.getInt("idRegion");
				String nomRegion = unRes.getString("nomRegion");
				
				
				//instation classe Region
				
				Region uneRegion = new Region(idRegion, nomRegion);
				
				lesRegions.add(uneRegion); //ajout données table Region
			}
			
			
			
			unRes.close();
			uneStat.close();
			uneBDD.seDeconnecter();
			
		}
		catch(SQLException exp) //gestion erreurs SQL
		{
			System.out.println("Erreur de la connexion " + requete);
		}
		
		return lesRegions;
	}
	public static void supprimer(int idRegion)
	{
		String requete = "delete from region where idRegion =" + idRegion;
		
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
			System.out.println("Erreur de de la suppression de la region : " + requete);
		}
	}
	
	public static void inserer(Region uneRegion)
	{
		String requete = "insert into region(nomRegion) "
						 + "values ('" + uneRegion.getNomRegion() + "');";
		
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
			System.out.println("Erreur de l'insertion de la region : " + requete);
		}
	}
	
	public static void MJ(int idRegion, String nomRegion)
	{
		String requete = "update region set nomRegion='" + nomRegion + "' where idRegion=" + idRegion;
		
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
			System.out.println("Erreur de la mise à jour de la region : " + requete);
		}
	}
	
}
