package Vues;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.prism.paint.ImagePattern;

import javax.swing.JFrame;

import Controleur.Profil;
import Controleur.Main;
import Modele.Modele;
 

public class Vue_connexion extends JPanel implements ActionListener, KeyListener
{
	private JTextField txtemail = new JTextField();
	private JPasswordField txtmdp = new JPasswordField();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btseConnecter = new JButton("Se connecter");
	
	public Vue_connexion()
	{
		this.setBounds(50, 100, 250, 150); //('', '','largeur', 'longeur')
		this.setLayout(new GridLayout(3, 2)); //colonne - ligne
		
		//visuel connexion
		this.add(new JLabel("email :"));
		this.add(this.txtemail);
		
		this.add(new JLabel("mot de passe :"));
		this.add(this.txtmdp);
		
		this.add(this.btAnnuler);
		this.add(this.btseConnecter);
		
		JFrame frame = new JFrame();	
		
		
		this.btseConnecter.setIcon(new ImageIcon("src/images/open_folder_add_256.png"));
		
		//rendre les boutons cliquable
		this.btAnnuler.addActionListener(this);
		this.btseConnecter.addActionListener(this); //ActionListener : evenement cliquable
		this.txtmdp.addKeyListener(this); //ajouter ecoute frappe de touche
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) //action pour éxécuter une action de bouton
	{
		if(e.getSource() == this.btAnnuler) //réinitialisation bouton annuler
		{
			this.txtemail.setText("");
			this.txtmdp.setText("");
			
		}
		else if (e.getSource() == this.btseConnecter) //récupération donnée puis insertion
		{
			this.actionConnexion();
		}
	}
	
	public void actionConnexion()
	{
		String email = this.txtemail.getText(); //equivalent en php à $reference = $_POST['reference'];
		String mdp = new String(this.txtmdp.getPassword());
		Profil unProfil = Modele.selectWhere(email, mdp);
		
		if(unProfil == null) //erreur de l'identification du formulaire
		{
			JOptionPane.showMessageDialog(this, "Erreur d'identification");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Bonjour "+unProfil.getNom());
			this.txtemail.setText("");
			this.txtmdp.setText("");
			
			new General(unProfil);
			Connexion.rendreVisible(false);
			Main.rendreVisible(false);
			
		}
	}

	@Override
	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.actionConnexion();
		}
		 
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

