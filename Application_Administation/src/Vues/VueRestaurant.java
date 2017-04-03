package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controleur.Restaurant;
import Modele.ModeleRestaurant;

public class VueRestaurant extends JPanel implements ActionListener, MouseListener //heritage librairie JPanel et implementation action liste bouton
{
	private JLabel lbTitre = new JLabel("Liste des Restaurants");
	private JTable tableRestaurants;
	
	public VueRestaurant()
	{
		this.setBounds(50, 50, 650, 250); //fenetre restaurant (margin-left,margin top, longueur, largeur)
		this.setLayout(null); //pas de photo
		this.setBackground(new Color(102, 153, 204)); //couleur bleu marine
		this.lbTitre.setBounds(150, 10, 200, 10); //placement titre
		this.add(this.lbTitre); //ajout titre
		
		//entete tableau
		String entete [] = {"id", "nom","nombre de tables", 
							"nombres de couverts", "telephone", "heure ouverture", 
							"heure fermeture", "ferExceptionnelle", "imageResto", "numero type restaurant",
							"code postal ville"};
		
		this.tableRestaurants = new JTable(this.extraireRestaurants(), entete); //creation tableaux
		JScrollPane uneScroll = new JScrollPane(tableRestaurants);
		uneScroll.setBounds(10, 40, 600, 200);
		this.add(uneScroll);
		
		this.setVisible(false);
		this.tableRestaurants.addMouseListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	
	public Object[][] extraireRestaurants() //methode unique pour l'affichage des données
	{
		ArrayList<Restaurant> lesRestaurant = ModeleRestaurant.selectAll(); //appelle Arraylist avec le model
		Object [][]donnees = new Object[lesRestaurant.size()][11]; //definition taille données
		int i = 0;
		
		for(Restaurant unRestaurant : lesRestaurant)
		{
			donnees [i][0] = unRestaurant.getIdResto();
			donnees [i][1] = unRestaurant.getNomResto();
			donnees [i][2] = unRestaurant.getNbTables();
			donnees [i][3] = unRestaurant.getNbCouverts();
			donnees [i][4] = unRestaurant.getTelResto();
			donnees [i][5] = unRestaurant.getHeureOuv();
			donnees [i][6] = unRestaurant.getHeureFer();
			donnees [i][7] = unRestaurant.getFerExceptionelle();
			donnees [i][8] = unRestaurant.getImageResto();
			donnees [i][9] = unRestaurant.getTypeResto();
			donnees [i][10] = unRestaurant.getCpVille();
			i++;
			
		}
		return donnees;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int lg = this.tableRestaurants.getSelectedRow();
		int ht = this.tableRestaurants.getSelectedColumn();
		int idResto = Integer.parseInt(this.tableRestaurants.getValueAt(lg, 0).toString());
		String nomResto = this.tableRestaurants.getValueAt(lg, 1).toString();
		int nbTables = Integer.parseInt(this.tableRestaurants.getValueAt(lg, 2).toString());
		int nbCouverts = Integer.parseInt(this.tableRestaurants.getValueAt(lg, 3).toString());
		String telResto = this.tableRestaurants.getValueAt(lg, 4).toString();
		Time heureOuv = Time.valueOf(this.tableRestaurants.getValueAt(lg, 5).toString());
		Time heureFer = Time.valueOf(this.tableRestaurants.getValueAt(lg, 6).toString());
		String ferExceptionelle = this.tableRestaurants.getValueAt(lg, 7).toString();
		String imageResto = this.tableRestaurants.getValueAt(lg, 8).toString();
		int idTypeResto = Integer.parseInt(this.tableRestaurants.getValueAt(lg, 9).toString());
		int cpVille = Integer.parseInt(this.tableRestaurants.getValueAt(lg, 10).toString());
		
		
		Restaurant unRestaurant = new Restaurant(idResto, nomResto, nbTables, nbCouverts, telResto, heureOuv,
		heureFer, ferExceptionelle, imageResto, idTypeResto, cpVille);
		
		VueEditionRestaurant.remplir(unRestaurant);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
