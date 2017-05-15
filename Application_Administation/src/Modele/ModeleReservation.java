package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import Controleur.Reservation;

public class ModeleReservation {
	
	public static ArrayList<Reservation> selectAll()
	{
		ArrayList<Reservation> lesReservations = new ArrayList<Reservation>(); //instation reservation
		
		String requete = " select * from reservation ";
		
		try
		{
			BDD uneBDD = new BDD("mysql.hostinger.fr", "u587264972_rest", "u587264972_rest", "ProjetPPE_1/"); //nouvel objet connexion
			
			uneBDD.seConnecter(); //connexion
			
			Statement uneStat = uneBDD.getMaconnexion().createStatement(); //instance connexion
			
			ResultSet unRes = uneStat.executeQuery(requete); //éxécution requête
			
			while(unRes.next())
			{
				int idReservation = unRes.getInt("idReservation");
				Date dateHeureReservation = unRes.getDate("date_heure_Reservation");
				int nbPersonnes = unRes.getInt("nbPersonnes");
				String statut = unRes.getString("statut");
				
				Reservation uneReservation = new Reservation(idReservation, dateHeureReservation, nbPersonnes, statut);
				
				lesReservations.add(uneReservation);
				
				
			}
			
			unRes.close();
			uneStat.close();
			uneBDD.seDeconnecter();
		}
		
		catch(SQLException exp)
		{
			System.out.println("Erreur de la connexion " + requete);
		}
		
		return lesReservations;
	}
	
	@SuppressWarnings("unused")
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
	public static void MJ(int idReservation, int nbPersonne, String statut)
	{
		String requete = "update reservation "
						 + "set nbPersonnes= " + nbPersonne + ", statut = '" + statut 
						 + "' where idReservation = " + idReservation + ";";
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
	
	public static void supprimer(int idRes)
	{
		String requete = "delete from reservation where idReservation=" + idRes;
		
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
}
