package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import Controleur.Restaurant;
import Modele.BDD;

public class ModeleRestaurant {
	
	public static ArrayList<Restaurant> selectAll() //méthode select tous restaurants
	{
		ArrayList<Restaurant> lesRestaurants = new ArrayList<Restaurant>();
		String requete = "select * from restaurant";
		
		try
		{
			BDD uneBDD = new BDD("localhost", "restline", "root", "");
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaconnexion().createStatement(); //créer une instance connexion
			ResultSet unRes = unStat.executeQuery(requete); //éxécute requête
			while(unRes.next())
			{
				int idResto = unRes.getInt("idResto");
				String nomResto = unRes.getString("nomResto");
				int nbTables = unRes.getInt("nbTables");
				int nbCouverts = unRes.getInt("nbCouverts");
				String telResto = unRes.getString("telResto");
				Time heureOuv = unRes.getTime("heureOuv");
				Time heureFer = unRes.getTime("heureFer");
				String ferExceptionelle = unRes.getString("ferExceptionnelle");
				String imageResto = unRes.getString("imageResto");
				int idTypeResto = unRes.getInt("idTypeResto");
				int cpVille = unRes.getInt("cpVille");
				
				Restaurant unRestaurant = new Restaurant(idResto, nomResto, nbTables, nbCouverts, telResto,
														 heureOuv, heureFer, ferExceptionelle, imageResto,
														 idTypeResto, cpVille);
				
				lesRestaurants.add(unRestaurant);
			}
			
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) //gestion erreurs SQL
		{
			System.out.println("Erreur d'affichage des restaurants" + requete);
		}
		return lesRestaurants;
	}
	
	public static void supprimer(int idResto) //methode supprimer restaurant
	{
		String requete = "delete from restaurant where idResto=" + idResto;
		
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
			System.out.println("Erreur de la suppresion du restaurant : " + requete);
		}
	}
	
	public static void Mj(int idResto, String nomResto, int nbTables, int nbCouverts, String telResto,
						  Time heureOuv, Time heureFer, String ferExceptionelle, String imageResto,
						  int idTypeResto, int cpVille) //methode mise à jour restaurant
	{
		String requete = "update restaurant set nbTables =" + nbTables
						 + ", nbCouverts =" + nbCouverts + ", telResto ='" + telResto + "', heureOuv='"
						 + heureOuv + "', heureFer ='" + heureFer + "', ferExceptionnelle='" + ferExceptionelle 
						 + "', imageResto ='" + imageResto + "', idTypeResto=" + idTypeResto 
						 + ", cpVille=" + cpVille + " where idResto=" + idResto + ";";
		
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
			System.out.println("Erreur de la mise à jour du restaurant : " + requete);
		}
	}
	
	public static void inserer(Restaurant unRestaurant)
	{
		String requete = "insert into restaurant(nomResto, nbTables, nbCouverts, telResto, heureOuv, heureFer,"
		+ "ferExceptionnelle, imageResto, idTypeResto, cpVille) values ('" + unRestaurant.getNomResto() + "' , " + unRestaurant.getNbCouverts() 
		+ ", " + unRestaurant.getNbCouverts() + ", '" + unRestaurant.getTelResto() + "', '" + unRestaurant.getHeureOuv()
		+ "', '" + unRestaurant.getHeureFer() + "', '" + unRestaurant.getFerExceptionelle() + "', '" + unRestaurant.getImageResto() 
		+ "', " + unRestaurant.getTypeResto() + ", " + unRestaurant.getCpVille() + ");";
		

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
			System.out.println("Erreur de l'insertion du restaurant : " + requete);
		}
	}
}
