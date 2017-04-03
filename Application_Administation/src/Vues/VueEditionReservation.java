package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.Reservation;
import Modele.ModeleReservation;

public class VueEditionReservation  extends JPanel implements ActionListener 
{
	private static JTextField idReservation = new JTextField();
	private static JTextField dateHeureReservation = new JTextField();
	private static JTextField nbPersonne = new JTextField();
	private static JTextField statut = new JTextField();
	
	private JLabel idR = new JLabel("numeros de la reservation");
	private JLabel dateHR = new JLabel("date de la reservation ");
	private JLabel nbP = new JLabel("nombre de personne");
	private JLabel st = new JLabel("Statut");
	
	private JButton btMJ = new JButton(new ImageIcon("src/Images/mj.jpg"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/Images/supprimer.jpg"));
	
	public VueEditionReservation()
	{
		this.setBounds(7, 320, 730, 225);	//('', '','largeur', 'longeur')
		this.setLayout(null);
		this.setBackground(new Color(102, 153, 204));//colonne - ligne
		
		idR.setBounds(20, 40, 100, 20);
		this.add(this.idR);
		idReservation.setBounds(140, 40, 100, 20);
		idReservation.setEditable(false);
		this.add(this.idReservation);
		
		nbP.setBounds(260, 40, 100, 20);
		this.add(this.nbP);
		nbPersonne.setBounds(380, 40, 100, 20);
		this.add(this.nbPersonne);
		
		st.setBounds(500, 40, 100, 20);
		this.add(this.st);
		statut.setBounds(620, 40, 100, 20);
		this.add(this.statut);
		

		btMJ.setBounds(20, 80, 40, 30);
		this.add(this.btMJ);
		btSupprimer.setBounds(70, 80, 40, 30);
		this.add(this.btSupprimer);
		
		this.btMJ.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.btSupprimer)
		{
			int idReser = Integer.parseInt(this.idReservation.getText().toString());
			ModeleReservation.supprimer(idReser);
			JOptionPane.showMessageDialog(this, "Supression de la reservation réussite");
		}
		
		else if(e.getSource() == this.btMJ)
		{
			int idReser = Integer.parseInt(this.idReservation.getText().toString());
			int nbPer = Integer.parseInt(this.nbPersonne.getText().toString());
			String statut = this.statut.getText().toString();
			
			ModeleReservation.MJ(idReser, nbPer, statut);
			JOptionPane.showMessageDialog(this, "Mise à jour de la reservation réussite");
		}
		
	}
	
	public static void remplir(Reservation uneReservation)
	{
		idReservation.setText(Integer.toString(uneReservation.getIdReservation()));
		nbPersonne.setText(Integer.toString(uneReservation.getNbPersonnes()));
		statut.setText(uneReservation.getStatut());
	}

}
