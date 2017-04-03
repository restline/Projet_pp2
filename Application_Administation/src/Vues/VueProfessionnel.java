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

import Controleur.Professionnel;
import Modele.ModeleProfessionnel;


public class VueProfessionnel extends JPanel implements ActionListener, MouseListener
{
	private JLabel lbTitre = new JLabel("Liste des Professionnels");
	private JTable tableClients ;
	
	public VueProfessionnel()
	{
		this.setBounds(50, 50, 650, 250);
		this.setLayout(null);
		this.setBackground(new Color(208, 210, 213));
		this.lbTitre.setBounds(150, 10, 200, 10);
		this.add(this.lbTitre);
		
		//construction de la Jtable 
		String entete [] = {"id", "Nom","Email", "Telephone",
							"Adresse", "Ville", "numeros Siret", "Nom Contact",
							"¨Prenom Cintact"};
		this.tableClients = new JTable(this.extraireClients(), entete);
		JScrollPane uneScroll = new JScrollPane(tableClients);
		uneScroll.setBounds(10, 40, 600, 200);
		this.add(uneScroll);
		
		this.setVisible(false);
		this.tableClients.addMouseListener(this);
	}
	private Object[][] extraireClients() {
		ArrayList<Professionnel> lesClients = ModeleProfessionnel.selectAll();
		Object [][]donnees = new Object[lesClients.size()][9];
		int i=0;
		for (Professionnel unClient : lesClients)
		{
			donnees [i][0] = unClient.getIdClient();
			donnees [i][1] = unClient.getNomClient();
			donnees [i][2] = unClient.getEmailClient();
			donnees [i][3] = unClient.getNumTelClient();
			donnees [i][4] = unClient.getRue();
			donnees [i][5] = unClient.getCp()+","+ unClient.getVille();
			donnees	[i][6] = unClient.getNumSiret();
			donnees [i][7] = unClient.getNomContact();
			donnees [i][8] = unClient.getPrenomContact();
			i++;
		}
		return donnees;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
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
		
		String numeroSiret = this.tableClients.getValueAt(lg, 6).toString();
		String nomContact = this.tableClients.getValueAt(lg, 7).toString();
		String prenomContact = this.tableClients.getValueAt(lg, 8).toString();
		
		Professionnel unClient = new Professionnel(idClient, nomClient, emailClient, numTelClient, cp, rue, ville,
												   "", numeroSiret, nomContact, prenomContact);
		
		VueEditionProfessionnel.remplir(unClient);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
