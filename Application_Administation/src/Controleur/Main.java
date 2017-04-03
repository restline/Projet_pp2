package Controleur;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Vues.Connexion;

public class Main {
	
	private static Connexion uneConnexion ; 
	public Main ()
	{
		uneConnexion = new Connexion(); 
	}
	
	public static void rendreVisible (boolean valeur) //methode pour rendre visible les pannels
	{
		uneConnexion.setVisible(valeur);
	}
	public static void main(String[] args)
	{
		 new Main();
	}
	public static String coderSha(String mdp) //methode coder mdp
	{
		StringBuffer sha = new StringBuffer();
		try
		{
			MessageDigest mDigest = MessageDigest.getInstance("SHA");
			byte[] result = mDigest.digest(mdp.getBytes());
			for(int i = 0; i < result.length; i++)
			{
				sha.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
		}
		catch(NoSuchAlgorithmException  l)
		{
			System.out.println("erreur du codage");
		}
		return sha.toString();
		
	}
	
}
 