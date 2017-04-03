package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controleur.Particulier;
import Modele.ModeleParticulier;

public class VueParticulier extends JPanel implements ActionListener, MouseListener
{
	private JLabel lbTitre = new JLabel("Liste des Particuliers");
	private JTable tableClients ;
	
	public VueParticulier()
	{
		this.setBounds(50, 50, 650, 250);
		this.setLayout(null);
		this.setBackground(new Color(208, 210, 213));
		this.lbTitre.setBounds(150, 10, 200, 10);
		this.add(this.lbTitre);
		
		//construction de la Jtable 
		String entete [] = {"id", "Nom","Email", "Telephone",
							"Adresse", "Ville", "Prenom"};
		this.tableClients = new JTable(this.extraireClients(), entete);
		JScrollPane uneScroll = new JScrollPane(tableClients);
		uneScroll.setBounds(10, 40, 600, 200);
		this.add(uneScroll);
		
		this.setVisible(false);
		this.tableClients.addMouseListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
	public Object [][] extraireClients()
	{
		ArrayList<Particulier> lesClients = ModeleParticulier.selectAll();
		Object [][]donnees = new Object[lesClients.size()][7];
		int i=0;
		for (Particulier unClient : lesClients)
		{
			donnees [i][0] = unClient.getIdClient();
			donnees [i][1] = unClient.getNomClient();
			donnees [i][2] = unClient.getEmailClient();
			donnees [i][3] = unClient.getNumTelClient();
			donnees [i][4] = unClient.getRue();
			donnees [i][5] = unClient.getCp()+","+ unClient.getVille();
			donnees	[i][6] = unClient.getPrenom();
			i++;
		}
		return donnees;
	}

	@Override
	public void mouseClicked(MouseEvent e) //obtenir le clique de la souris sur la table
	{
		// TODO Auto-generated method stub
		int lg = this.tableClients.getSelectedRow();
		int ht = this.tableClients.getSelectedColumn();
		int idClient = Integer.parseInt(this.tableClients.getValueAt(lg, 0).toString());
		String nomClient = this.tableClients.getValueAt(lg, 1).toString();
		String emailClient = this.tableClients.getValueAt(lg, 2).toString();
		String numTelClient = this.tableClients.getValueAt(lg, 3).toString();
		String rue = this.tableClients.getValueAt(lg, 4).toString();
		String chaine = this.tableClients.getValueAt(lg, 5).toString();
		
		String tab[] = new String [2];
		tab = chaine.split(",");
		String ville = tab[1];
		String cp = tab[0];
		
		String prenom = this.tableClients.getValueAt(lg, 6).toString();
		
		Particulier unClient = new Particulier(idClient, nomClient, emailClient, numTelClient, cp, rue, ville, "", prenom);
		VueEditionParticulier.remplir(unClient);
		
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
