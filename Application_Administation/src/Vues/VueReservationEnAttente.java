package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controleur.Reservation;
import Modele.ModeleReservation;

public class VueReservationEnAttente extends JPanel implements ActionListener
{
	private JLabel lbTitre = new JLabel("Liste des Reservations");
	private JTable tableReservations;
	
	public VueReservationEnAttente()
	{
		this.setBounds(50, 10, 450, 260); //fenetre restaurant (margin-left,margin top, longueur, largeur)
		this.setLayout(null); //pas de photo
		this.setBackground(new Color(102, 153, 204)); //couleur bleu marine
		this.lbTitre.setBounds(160, -10, 200, 50); //placement titre
		this.add(this.lbTitre); //ajout titre
		
		String entete [] = {"id", "date_heure", "nombre de personnes", "statut"};
		
		this.tableReservations = new JTable(this.extraireReservations(), entete); //creation tableaux
		JScrollPane uneScroll = new JScrollPane(tableReservations);
		uneScroll.setBounds(25, 30, 400, 180);
		this.add(uneScroll);
		
		this.setVisible(false);
	}

	private Object[][] extraireReservations() {
		ArrayList<Reservation> lesReservations = ModeleReservation.selectStatutEnAttente();
		Object [][]donnees = new Object[lesReservations.size()][4];
		int i = 0;
		
		for(Reservation uneReservation : lesReservations)
		{
			donnees [i][0] = uneReservation.getIdReservation();
			donnees [i][1] = uneReservation.getDateHeureReservation();
			donnees [i][2] = uneReservation.getNbPersonnes();
			donnees [i][3] = uneReservation.getStatut();
			i++;
			
		}
		
		return donnees;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
