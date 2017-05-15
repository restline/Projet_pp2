package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controleur.Commentaires;

public class ModeleCommentaires 
{
	public static ArrayList<Commentaires> selectAll()
	{
		ArrayList<Commentaires> lesCommentaires = new ArrayList<Commentaires>();
		String requete = "select * from commentaires";
		
		try
		{
			BDD uneBDD = new BDD("mysql.hostinger.fr", "u587264972_rest", "u587264972_rest", "ProjetPPE_1/");
			uneBDD.seConnecter();
			Statement unStat = uneBDD.getMaconnexion().createStatement(); //créer une instance connexion
			ResultSet unRes = unStat.executeQuery(requete); //éxécute requête
			while(unRes.next())
			{
				int idCom = unRes.getInt("idCom");
				String auteurCom = unRes.getString("auteurCom");
				String sujetCom = unRes.getString("sujetCom");
				String texteCom = unRes.getString("texteCom");
				int idClient = unRes.getInt("idClient");
				
				Commentaires unCommentaire = new Commentaires(idCom, auteurCom, 
															  sujetCom, texteCom, idClient);
				lesCommentaires.add(unCommentaire);
			}
			unStat.close();
			unRes.close();
			uneBDD.seDeconnecter();
		}
		catch(SQLException exp) //gestion erreurs SQL
		{
			System.out.println("Erreur d'affichage des commentaires" + requete);
		}
		
		return lesCommentaires;
	}
	
	public static void supprimer(int idCom)
	{
		String requete = "delete from commentaires where idCom=" + idCom;
		
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
			System.out.println("Erreur de  la suppressiob du commentaire : " + requete);
		}
	}
	
}
