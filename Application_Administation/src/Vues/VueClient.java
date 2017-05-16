package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controleur.Client;
import Modele.ModeleClient;

public class VueClient extends JPanel implements ActionListener
{
	private JLabel lbTitre = new JLabel("Liste des clients");
	private JTable tableClients ;
	
	public VueClient()
	{
		this.setBounds(50, 50, 450, 250);
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		this.lbTitre.setBounds(150, 10, 200, 10);
		this.add(this.lbTitre);
		
		//construction de la Jtable 
		String entete [] = {"id", "Nom","Email", "Telephone",
							"Adresse", "Ville"};
		this.tableClients = new JTable(this.extraireClients(), entete);
		JScrollPane uneScroll = new JScrollPane(tableClients);
		uneScroll.setBounds(10, 40, 420, 200);
		this.add(uneScroll);
		
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
	public Object [][] extraireClients()
	{
		ArrayList<Client> lesClients = ModeleClient.selectAll();
		Object [][]donnees = new Object[lesClients.size()][6];
		int i=0;
		for (Client unClient : lesClients)
		{
			donnees [i][0] = unClient.getIdClient();
			donnees [i][1] = unClient.getNomClient();
			donnees [i][2] = unClient.getEmailClient();
			donnees [i][3] = unClient.getNumTelClient();
			donnees [i][4] = unClient.getRue();
			donnees [i][5] = unClient.getCp()+" "+ unClient.getVille();
			i++;
		}
		return donnees;
	}
}
