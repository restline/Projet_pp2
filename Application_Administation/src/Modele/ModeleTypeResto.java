package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controleur.TypeResto;

public class ModeleTypeResto 
{
	public static ArrayList<TypeResto> selectAll()
	{
		ArrayList<TypeResto> lesTypeRestos = new ArrayList<TypeResto>(); //instantacion de l'arraylist
		
		String requete = "select * from typeresto"; //requête
		
		try
		{
			BDD uneBDD = new BDD("localhost", "restline", "root", ""); //instation d'une nouvelle connexion
			
			uneBDD.seConnecter(); //connexion
			
			Statement uneStat = uneBDD.getMaconnexion().createStatement(); //instance connexion
			
			ResultSet unRes = uneStat.executeQuery(requete); //exécution requête
			
			while(unRes.next())
			{
				int idTypeResto = unRes.getInt("idTypeResto");
				String libelle = unRes.getString("libelle");
				String catPrix = unRes.getString("catPrix");
				int nbEtoiles = unRes.getInt("nbEtoiles");
				
				//instation classe restaurant
				
				TypeResto unTypeResto = new TypeResto(idTypeResto, libelle, catPrix, nbEtoiles);
				
				lesTypeRestos.add(unTypeResto); //ajout données table restaurant
			}
			
			
			
			unRes.close();
			uneStat.close();
			uneBDD.seDeconnecter();
			
		}
		catch(SQLException exp) //gestion erreurs SQL
		{
			System.out.println("Erreur de la connexion " + requete);
		}
		
		return lesTypeRestos;
	}
	
	public static void supprimer(int idTypeResto)
	{
		String requete = "delete from typeresto where idTypeResto=" + idTypeResto;
		
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
			System.out.println("Erreur de la suppresion du type de restaurant : " + requete);
		}
	}
	public static void inserer(TypeResto unTypeResto)
	{
		String requete = "insert into typeresto(libelle, catPrix, nbEtoiles)"
					  + " values ('" + unTypeResto.getLibelle() + "', '" + unTypeResto.getCatPrix() + "', "
					  + unTypeResto.getNbEtoiles() + ");";
		
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
			System.out.println("Erreur d'insertion du type de restaurant : " + requete);
		}
					  
	}
	
	public static void MJ(int idTypeResto, String libelle, String catPrix, int nbEtoiles)
	{
		String requete = "update typeresto set libelle='" + libelle + "', catPrix='" + catPrix 
	    + "', nbEtoiles=" + nbEtoiles + " where idTypeResto=" + idTypeResto;
		
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
			System.out.println("Erreur d'insertion de mise a jour du restaurant : " + requete);
		}
	}
}
