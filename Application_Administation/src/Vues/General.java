package Vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


import Controleur.Profil;


public class General extends JFrame implements ActionListener
{
	//definition des menu, item et vues sur les fenêtres
	private JMenuBar uneBarre = new JMenuBar(); 
	private JMenu mnFichier = new JMenu("Fichier");
	private JMenu mnOperations = new JMenu("Client");
	private JMenu mnRestaurant = new JMenu("Restaurant");
	private JMenu maReservation = new JMenu("Reservation");
	private JMenu monTypeResto = new JMenu("Type Restaurant");
	private JMenu maVille = new JMenu("Ville");
	private JMenu maRegion = new JMenu("Regions");
	private JMenu monCommentaire = new JMenu("Commentaires");
	private JMenu mnAide = new JMenu("Aide");
	
	private JMenuItem  itemQuitter = new JMenuItem ("Quitter");
	private JMenuItem  itemLister = new JMenuItem ("Lister Particulier"); //pour le client
	private JMenuItem itemListerPro = new JMenuItem(" Lister Professionnel");
	private JMenuItem  itemListerRestaurant = new JMenuItem("Lister Restaurants");
	private JMenuItem  itemListerReservation = new JMenuItem("Lister Reservations");
	private JMenuItem itemTypeResto = new JMenuItem("Lister Type de Restaurant");
	private JMenuItem itemVille = new JMenuItem("Lister les Villes");
	private JMenuItem itemRegion = new JMenuItem("Lister les Regions");
	private JMenuItem itemCommentaires = new JMenuItem("Lister les Commentaires");
	private JMenuItem  itemApropos= new JMenuItem ("A Propos");
	
	//les vues de base
	private VueAccueil uneVueAccueil ;
	private VueParticulier uneVueParticulier;
	private VueProfessionnel uneVueProfessionnel;
	private VueRestaurant uneVueRestaurant;
	private VueReservation uneVueReservation;
	private VueTypeResto uneVueTypeResto;
	private VueVille uneVueVille;
	private VueRegion uneVueRegion;
	private VueCommentaires uneVueCommentaires;
	private VueAPropos uneVueAPropos;
	
	//les vue pour l'edition du tableau
	private VueEditionParticulier uneVueEditionParticulier;
	private VueEditionProfessionnel uneVueEditionProfessionnel;
	private VueEditionRestaurant uneVueEditionRestaurant;
	private VueEditionReservation uneVueEditionReservation;
	private VueEditionTypeResto uneVueEditionTypeResto;
	private VueEditionVille uneVueEditionVille;
	private VueEditionRegion uneVueEditionRegion;
	private VueEditionCommentaires uneVueEditionCommentaires;
	
	//image fond d'ecrans
	private Image img;
	
	public General(Profil unProfil) //constructeur pour initialiser classe
	{
		this.setTitle("Menu Administration");
		this.setLayout(null);
		this.setBounds(200, 100, 750, 600);
		//this.img = Toolkit.getDefaultToolkit().getImage("src/Images/Resto.jpg");
		this.uneBarre.setBackground(new Color(102, 153, 204));
		
		 
		this.setResizable(false);
		
		this.uneVueAccueil = new VueAccueil(unProfil);
		this.add(uneVueAccueil);
		
		this.uneVueParticulier = new VueParticulier();
		this.add(this.uneVueParticulier);
		
		this.uneVueProfessionnel = new VueProfessionnel();
		this.add(this.uneVueProfessionnel);
		
		this.uneVueRestaurant = new VueRestaurant();
		this.add(this.uneVueRestaurant);
		
		this.uneVueReservation = new VueReservation();
		this.add(this.uneVueReservation);
		
		this.uneVueTypeResto = new VueTypeResto();
		this.add(this.uneVueTypeResto);
		
		this.uneVueVille = new VueVille();
		this.add(this.uneVueVille);
		
		this.uneVueRegion = new VueRegion();
		this.add(this.uneVueRegion);
		
		this.uneVueCommentaires = new VueCommentaires();
		this.add(this.uneVueCommentaires);
		
		this.uneVueEditionParticulier = new VueEditionParticulier();
		this.add(this.uneVueEditionParticulier);
		
		this.uneVueEditionProfessionnel = new VueEditionProfessionnel();
		this.add(this.uneVueEditionProfessionnel);
		
		this.uneVueEditionRestaurant = new VueEditionRestaurant();
		this.add(this.uneVueEditionRestaurant);
		
		this.uneVueEditionReservation = new VueEditionReservation();
		this.add(this.uneVueEditionReservation);
		
		this.uneVueEditionTypeResto = new VueEditionTypeResto();
		this.add(this.uneVueEditionTypeResto);
		
		this.uneVueEditionVille = new VueEditionVille();
		this.add(this.uneVueEditionVille);
		
		this.uneVueEditionRegion = new VueEditionRegion();
		this.add(this.uneVueEditionRegion);
		
		this.uneVueEditionCommentaires = new VueEditionCommentaires();
		this.add(this.uneVueEditionCommentaires);
		
		this.uneVueAPropos = new VueAPropos();
		this.add(this.uneVueAPropos);
		
		this.mnFichier.add(itemQuitter);
		
		//construction des menus 
		if (unProfil.isPermission()==true) //si la permission est 1
		{
			this.mnOperations.add(itemLister);
			this.mnOperations.add(itemListerPro);
			this.mnRestaurant.add(itemListerRestaurant);
			this.maReservation.add(itemListerReservation);
			this.monTypeResto.add(itemTypeResto);
			this.maVille.add(itemVille);
			this.maRegion.add(itemRegion);
			this.monCommentaire.add(itemCommentaires);
		}
		
		
		
		//ajout à la barre 
		
		this.mnAide.add(itemApropos);
		this.uneBarre.add(mnFichier);
		this.uneBarre.add(mnOperations);
		this.uneBarre.add(mnRestaurant);
		this.uneBarre.add(maReservation);
		this.uneBarre.add(monTypeResto);
		this.uneBarre.add(maVille);
		this.uneBarre.add(maRegion);
		this.uneBarre.add(monCommentaire);
		this.uneBarre.add(mnAide);
		this.setJMenuBar(uneBarre);
		
		//Actions cliquables
		this.itemLister.addActionListener(this);
		this.itemListerPro.addActionListener(this);
		this.itemListerRestaurant.addActionListener(this);
		this.itemListerReservation.addActionListener(this);
		this.itemQuitter.addActionListener(this);
		this.itemTypeResto.addActionListener(this);
		this.itemVille.addActionListener(this);
		this.itemRegion.addActionListener(this);
		this.itemCommentaires.addActionListener(this);
		this.itemApropos.addActionListener(this);
		
		ImageIcon icon = new ImageIcon("src/Images/Resto.jpg");
		JLabel l = new JLabel(icon);
		l.setBounds(0, 0,750, 600);	
		this.getContentPane().add(l);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==this.itemQuitter) //si on cliquer sur l'onglet quitter
		 {
			 int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'administration de Restline?",
					 "Quitter", JOptionPane.ERROR_MESSAGE);
			 if (retour ==0) //kill la fenêtre
			 {
				 this.dispose();
			 }
		 }
		 else if (e.getSource() == this.itemApropos)
		 {
			 this.uneVueAccueil.setVisible(false);
			 this.uneVueReservation.setVisible(false);
			 this.uneVueRestaurant.setVisible(false);
			 this.uneVueTypeResto.setVisible(false);
			 this.uneVueVille.setVisible(false);
			 this.uneVueRegion.setVisible(false);
			 this.uneVueProfessionnel.setVisible(false);
			 this.uneVueEditionProfessionnel.setVisible(false);
			 this.uneVueEditionRestaurant.setVisible(false);
			 this.uneVueEditionReservation.setVisible(false);
			 this.uneVueEditionTypeResto.setVisible(false);
			 this.uneVueEditionVille.setVisible(false);
			 this.uneVueEditionRegion.setVisible(false);
			 this.uneVueCommentaires.setVisible(false);
			 this.uneVueEditionCommentaires.setVisible(false);
			 this.uneVueParticulier.setVisible(false);
			 this.uneVueEditionParticulier.setVisible(false);
			 this.uneVueAPropos.setVisible(true);
		 }
		 else if (e.getSource()==this.itemLister) 
		 {
			 this.uneVueAccueil.setVisible(false);
			 this.uneVueReservation.setVisible(false);
			 this.uneVueRestaurant.setVisible(false);
			 this.uneVueTypeResto.setVisible(false);
			 this.uneVueVille.setVisible(false);
			 this.uneVueRegion.setVisible(false);
			 this.uneVueProfessionnel.setVisible(false);
			 this.uneVueEditionProfessionnel.setVisible(false);
			 this.uneVueEditionRestaurant.setVisible(false);
			 this.uneVueEditionReservation.setVisible(false);
			 this.uneVueEditionTypeResto.setVisible(false);
			 this.uneVueEditionVille.setVisible(false);
			 this.uneVueEditionRegion.setVisible(false);
			 this.uneVueCommentaires.setVisible(false);
			 this.uneVueEditionCommentaires.setVisible(false);
			 this.uneVueAPropos.setVisible(false);
			 this.uneVueParticulier.setVisible(true);
			 this.uneVueEditionParticulier.setVisible(true);
			 
		 }
		 else if(e.getSource() == this.itemListerPro)
		 {
			 this.uneVueAccueil.setVisible(false);
			 this.uneVueReservation.setVisible(false);
			 this.uneVueRestaurant.setVisible(false);
			 this.uneVueEditionRestaurant.setVisible(false);
			 this.uneVueTypeResto.setVisible(false);
			 this.uneVueVille.setVisible(false);
			 this.uneVueRegion.setVisible(false);
			 this.uneVueParticulier.setVisible(false);
			 this.uneVueEditionReservation.setVisible(false);
			 this.uneVueEditionTypeResto.setVisible(false);
			 this.uneVueEditionVille.setVisible(false);
			 this.uneVueEditionRegion.setVisible(false);
			 this.uneVueCommentaires.setVisible(false);
			 this.uneVueEditionCommentaires.setVisible(false);
			 this.uneVueParticulier.setVisible(false);
			 this.uneVueEditionParticulier.setVisible(false);
			 this.uneVueAPropos.setVisible(false);
			 this.uneVueProfessionnel.setVisible(true);
			 this.uneVueEditionProfessionnel.setVisible(true);
		 }
		 else if(e.getSource()==this.itemListerRestaurant)
		 {
			 this.uneVueAccueil.setVisible(false);
			 this.uneVueReservation.setVisible(false);
			 this.uneVueParticulier.setVisible(false);
			 this.uneVueVille.setVisible(false);
			 this.uneVueRegion.setVisible(false);
			 this.uneVueEditionParticulier.setVisible(false);
			 this.uneVueProfessionnel.setVisible(false);
			 this.uneVueEditionProfessionnel.setVisible(false);
			 this.uneVueEditionReservation.setVisible(false);
			 this.uneVueEditionTypeResto.setVisible(false);
			 this.uneVueEditionVille.setVisible(false);
			 this.uneVueEditionRegion.setVisible(false);
			 this.uneVueCommentaires.setVisible(false);
			 this.uneVueEditionCommentaires.setVisible(false);
			 this.uneVueRestaurant.setVisible(true);
			 this.uneVueEditionRestaurant.setVisible(true);
		 }
		 else if(e.getSource()==this.itemListerReservation)
		 {
			 this.uneVueAccueil.setVisible(false);
			 this.uneVueParticulier.setVisible(false);
			 this.uneVueRestaurant.setVisible(false);
			 this.uneVueEditionRestaurant.setVisible(false);
			 this.uneVueTypeResto.setVisible(false);
			 this.uneVueVille.setVisible(false);
			 this.uneVueRegion.setVisible(false);
			 this.uneVueEditionParticulier.setVisible(false);
			 this.uneVueProfessionnel.setVisible(false);
			 this.uneVueEditionProfessionnel.setVisible(false);
			 this.uneVueEditionTypeResto.setVisible(false);
			 this.uneVueEditionVille.setVisible(false);
			 this.uneVueEditionRegion.setVisible(false);
			 this.uneVueCommentaires.setVisible(false);
			 this.uneVueEditionCommentaires.setVisible(false);
			 this.uneVueAPropos.setVisible(false);
			 this.uneVueReservation.setVisible(true);
			 this.uneVueEditionReservation.setVisible(true);
		 }
		 else if(e.getSource()==this.itemTypeResto)
		 {
			 this.uneVueAccueil.setVisible(false);
			 this.uneVueParticulier.setVisible(false);
			 this.uneVueRestaurant.setVisible(false);
			 this.uneVueEditionRestaurant.setVisible(false);
			 this.uneVueReservation.setVisible(false);
			 this.uneVueVille.setVisible(false);
			 this.uneVueRegion.setVisible(false);
			 this.uneVueEditionParticulier.setVisible(false);
			 this.uneVueProfessionnel.setVisible(false);
			 this.uneVueEditionProfessionnel.setVisible(false);
			 this.uneVueEditionReservation.setVisible(false);
			 this.uneVueEditionVille.setVisible(false);
			 this.uneVueEditionRegion.setVisible(false);
			 this.uneVueCommentaires.setVisible(false);
			 this.uneVueEditionCommentaires.setVisible(false);
			 this.uneVueAPropos.setVisible(false);
			 this.uneVueTypeResto.setVisible(true);
			 this.uneVueEditionTypeResto.setVisible(true);
		 }
		 else if(e.getSource()==this.itemVille)
		 {
			 this.uneVueAccueil.setVisible(false);
			 this.uneVueParticulier.setVisible(false);
			 this.uneVueRestaurant.setVisible(false);
			 this.uneVueEditionRestaurant.setVisible(false);
			 this.uneVueReservation.setVisible(false);
			 this.uneVueTypeResto.setVisible(false);
			 this.uneVueRegion.setVisible(false);
			 this.uneVueEditionParticulier.setVisible(false);
			 this.uneVueProfessionnel.setVisible(false);
			 this.uneVueEditionProfessionnel.setVisible(false);
			 this.uneVueEditionReservation.setVisible(false);
			 this.uneVueEditionTypeResto.setVisible(false);
			 this.uneVueEditionRegion.setVisible(false);
			 this.uneVueCommentaires.setVisible(false);
			 this.uneVueEditionCommentaires.setVisible(false);
			 this.uneVueAPropos.setVisible(false);
			 this.uneVueVille.setVisible(true);
			 this.uneVueEditionVille.setVisible(true);
		 }
		 else if(e.getSource()==this.itemRegion)
		 {
			 this.uneVueAccueil.setVisible(false);
			 this.uneVueParticulier.setVisible(false);
			 this.uneVueRestaurant.setVisible(false);
			 this.uneVueEditionRestaurant.setVisible(false);
			 this.uneVueReservation.setVisible(false);
			 this.uneVueTypeResto.setVisible(false);
			 this.uneVueVille.setVisible(false);
			 this.uneVueEditionParticulier.setVisible(false);
			 this.uneVueProfessionnel.setVisible(false);
			 this.uneVueEditionProfessionnel.setVisible(false);
			 this.uneVueEditionReservation.setVisible(false);
			 this.uneVueEditionTypeResto.setVisible(false);
			 this.uneVueEditionVille.setVisible(false);
			 this.uneVueCommentaires.setVisible(false);
			 this.uneVueEditionCommentaires.setVisible(false);
			 this.uneVueAPropos.setVisible(false);
			 this.uneVueRegion.setVisible(true);
			 this.uneVueEditionRegion.setVisible(true);
			 
		 }
		 
		 else if(e.getSource() == this.itemCommentaires)
		 {
			 this.uneVueAccueil.setVisible(false);
			 this.uneVueParticulier.setVisible(false);
			 this.uneVueRestaurant.setVisible(false);
			 this.uneVueEditionRestaurant.setVisible(false);
			 this.uneVueReservation.setVisible(false);
			 this.uneVueTypeResto.setVisible(false);
			 this.uneVueVille.setVisible(false);
			 this.uneVueEditionParticulier.setVisible(false);
			 this.uneVueProfessionnel.setVisible(false);
			 this.uneVueEditionProfessionnel.setVisible(false);
			 this.uneVueEditionReservation.setVisible(false);
			 this.uneVueEditionTypeResto.setVisible(false);
			 this.uneVueEditionVille.setVisible(false);
			 this.uneVueRegion.setVisible(false);
			 this.uneVueEditionRegion.setVisible(false);
			 this.uneVueAPropos.setVisible(false);
			 this.uneVueCommentaires.setVisible(true);
			 this.uneVueEditionCommentaires.setVisible(true);
		 }
		 
	}
	 public void paint(Graphics g)
	    {
	        // Draws the img to the BackgroundPanel.
		  	super.paintComponents(g);
	        g.drawImage(img, 0, 0, null);
	    }
	
}
