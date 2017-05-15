package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controleur.Reservation;
import Modele.ModeleReservation;

public class VueReservation extends JPanel implements ActionListener, MouseListener
{
	private JLabel lbTitre = new JLabel("Liste des Reservations");
	private JTable tableReservations;
	
	public VueReservation()
	{
		this.setBounds(50, 50, 622, 250); //fenetre restaurant (margin-left,margin top, longueur, largeur)
		this.setLayout(null); //pas de photo
		this.setBackground(new Color(130, 196, 108)); //couleur bleu marine
		this.lbTitre.setBounds(250, 10, 200, 10); //placement titre
		this.add(this.lbTitre); //ajout titre
		
		String entete [] = {"id", "date", "nombre de personnes", "statut"};
		
		this.tableReservations = new JTable(this.extraireReservations(), entete); //creation tableaux
		JScrollPane uneScroll = new JScrollPane(tableReservations);
		uneScroll.setBounds(10, 40, 600, 200);
		this.add(uneScroll);
		
		this.setVisible(false);
		this.tableReservations.addMouseListener(this);
	}

	private Object[][] extraireReservations() {
		ArrayList<Reservation> lesReservations = ModeleReservation.selectAll();
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

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int lg = this.tableReservations.getSelectedRow();
		int ht = this.tableReservations.getSelectedColumn();
		int idR = Integer.parseInt(this.tableReservations.getValueAt(lg, 0).toString());
		Date dateHR = Date.valueOf(this.tableReservations.getValueAt(lg, 1).toString());
		int nbP = Integer.parseInt(this.tableReservations.getValueAt(lg, 2).toString());
		String st = this.tableReservations.getValueAt(lg, 3).toString();
		
		Reservation uneReservation = new Reservation(idR, dateHR, nbP, st);
		VueEditionReservation.remplir(uneReservation);
		
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
