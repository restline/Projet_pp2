package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
	private String serveur, bdd, user, mdp;
	private Connection maConnexion;
	
	public BDD(String serveur, String bdd, String user, String mdp)
	{
		//initialisation attribut
		this.serveur = serveur;
		this.bdd = bdd;
		this.user = user;
		this.mdp = mdp;
	}
	
	public void chargerPilote() //méthode pour charger le pilote
	{
		//vérifie la précense du pilote mysql
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException exp)
		{
			System.out.println("pilote mysql absent");
		}
	}
	
	public void seConnecter() //méthode pour connection pilote
	{
		//vérifie la connection du pilote
		String url = "jdbc:mysql://"+this.serveur+"/"+this.bdd;
		this.chargerPilote();
		
		try
		{
			this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la connexion a " + url);
			exp.printStackTrace();
		}
	}
	
	public void seDeconnecter() //méthode déconnection pilote
	{
		//vérifie la déconnection du pilote
		try
		{
			if(this.maConnexion != null)
			{
				this.maConnexion.close();
			}
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la fermeture de connexion");
		}
	}
	
	public Connection getMaconnexion() //méthode pour obtenir pilote
	{
		return this.maConnexion;
	}
}
