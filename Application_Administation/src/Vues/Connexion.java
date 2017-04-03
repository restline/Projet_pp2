package Vues;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Connexion extends JFrame{
	private static Vue_connexion uneVueConnexion ; 
	private JLabel monLabel;
	private ImageIcon monIcone; 
	
	public Connexion() //1ere fenêtre pour la connexion
	{
		this.setTitle("Administration de l'application");
		this.setLayout(null);
		this.setBounds(200, 200, 350, 350);
		this.getContentPane().setBackground(Color.white);
		uneVueConnexion = new Vue_connexion();
		
		this.add(uneVueConnexion );
		this.setResizable(false);
		monLabel = new JLabel();
		monIcone = new ImageIcon("src/Images/Logo_rest.png" );
		monLabel.setIcon(monIcone);
		monLabel.setBounds(100, 0, 300, 100);
		this.getContentPane().add(monLabel); //("src/Images/fenetre_connexion.jpg").getImage())); 
		this.setVisible(true);
	}
	
	
	public static void rendreVisible (boolean valeur)
	{
		uneVueConnexion.setVisible(valeur);
	}
	
}
