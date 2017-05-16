package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import Controleur.Reservation;
import Modele.ModeleReservation;


public class VueMiseAJourReservation  extends JPanel implements ActionListener
{
	private JLabel lbTitre = new JLabel("Mettre à jour statut les Reservations");
	private String[] choixStatut = {"En attente", "Éffectué"};
	private JComboBox statut = new JComboBox(this.choixStatut);
	private JCheckBox selectionLigne = new JCheckBox();
	private JTable tableMJReservations;
	
	
	
	private JButton Maj = new JButton("Mise à Jour");
	
	public VueMiseAJourReservation()
	{
		this.setBounds(50, 10, 450, 240); //fenetre reservation (margin-left,margin top, longueur, largeur)
		this.setLayout(null); //pas de photo
		this.setBackground(new Color(102, 153, 204)); //couleur bleu marine
		this.lbTitre.setBounds(160, -10, 200, 50); //placement titre
		this.add(this.lbTitre); //ajout titre
		
		String entete [] = {"id de la Reservation", " date et heure", "nombre de personne", 
							"statut", "sélection"};
		
		this.tableMJReservations = new JTable(this.extraireReservations(), entete); //creation tableaux
		this.tableMJReservations.getColumnModel().getColumn(3).setCellRenderer(new VueJComboJCheck());
		JScrollPane uneScroll = new JScrollPane(this.tableMJReservations);
		uneScroll.setBounds(25, 30, 400, 100);
		this.add(uneScroll);
		
		this.setVisible(false);
		
		this.Maj.setBounds(80, 140, 100, 50);
		this.add(this.Maj);
		
		this.Maj.addActionListener(this);
		this.setVisible(false);
	}
	private Object[][] extraireReservations() {
		
		ArrayList<Reservation> lesReservations = ModeleReservation.selectAll();
	
		Object [][]donnees = new Object[lesReservations.size()][5];
		
		int i = 0;

		for(Reservation uneReservation : lesReservations)
		{
			donnees [i][0] = uneReservation.getIdReservation();
			donnees [i][1] = uneReservation.getDateHeureReservation();
			donnees [i][2] = uneReservation.getNbPersonnes();
			donnees [i][3] = this.statut.getSelectedItem();
			donnees [i][4] = this.selectionLigne.isSelected();
			i++;
		}
		return donnees;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.selectionLigne.isSelected())
		{
			this.Maj.setEnabled(true);
			this.Maj.setVisible(true);
		}
		if(this.selectionLigne.isSelected() && e.getSource() == this.Maj)
		{	
			String statut = (String)this.statut.getSelectedItem();
			try
			{
				
			}
			catch(NumberFormatException exp)
			{
				
				JOptionPane.showMessageDialog(this, "Mise à jour raté"); //message
			}
		}
		
		
	}
	
}
