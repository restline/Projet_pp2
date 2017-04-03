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

import Controleur.Ville;
import Modele.ModeleVille;

public class VueVille extends JPanel implements ActionListener, MouseListener
{
	
	private JLabel lbTitre = new JLabel("Liste des Villes");
	private JTable tableVille;
	
	public VueVille()
	{
		this.setBounds(50, 50, 650, 250); //fenetre ville (margin-left,margin top, longueur, largeur)
		this.setLayout(null); //pas de photo
		this.setBackground(new Color(102, 153, 204)); //couleur bleu marine
		this.lbTitre.setBounds(150, 10, 200, 10); //placement titre
		this.add(this.lbTitre); //ajout titre
		
		//entete tableau
		String entete [] = {"Numeros ","Nom de la ville ", "CP des Regions"};
		
		this.tableVille = new JTable(this.extraireVille(), entete); //creation tableaux
		JScrollPane uneScroll = new JScrollPane(tableVille);
		uneScroll.setBounds(10, 40, 600, 200);
		this.add(uneScroll);
		
		this.setVisible(false);
		this.tableVille.addMouseListener(this);
		
	}
	private Object[][] extraireVille() {
		
		ArrayList<Ville> lesVilles = ModeleVille.selectAll();
		
		Object [][]donnees = new Object[lesVilles.size()][3];
		
		int i = 0;
		
		for(Ville uneVille : lesVilles)
		{
			donnees [i][0] = uneVille.getCpVille();
			donnees [i][1] = uneVille.getNomVille();
			donnees	[i][2] = uneVille.getIdRegion();
			i++;
		}
		return donnees;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int lg = this.tableVille.getSelectedRow();
		int ht = this.tableVille.getSelectedColumn();
		int idV = Integer.parseInt(this.tableVille.getValueAt(lg, 0).toString());
		String nomV = this.tableVille.getValueAt(lg, 1).toString();
		int idReg = Integer.parseInt(this.tableVille.getValueAt(lg, 2).toString());
		
		Ville uneVille = new Ville(idV, nomV, idReg);
		VueEditionVille.remplir(uneVille);
		
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

}
