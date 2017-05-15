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

import Controleur.Region;
import Modele.ModeleRegion;


public class VueRegion extends JPanel implements ActionListener, MouseListener
{
	private JLabel lbTitre = new JLabel("Liste des Regions");
	private JTable tableRegion;
	
	public VueRegion()
	{
		this.setBounds(50, 50, 622, 250); //fenetre restaurant (margin-left,margin top, longueur, largeur)
		this.setLayout(null); //pas de photo
		this.setBackground(new Color(130, 196, 108)); //couleur bleu marine
		this.lbTitre.setBounds(250, 10, 200, 10); //placement titre
		this.add(this.lbTitre); //ajout titre
		
		//entete tableau
		String entete [] = {"cp de la region","nom de la region"};
		
		this.tableRegion = new JTable(this.extraireRegion(), entete); //creation tableaux
		JScrollPane uneScroll = new JScrollPane(tableRegion);
		uneScroll.setBounds(10, 40, 600, 200);
		this.add(uneScroll);
		
		this.setVisible(false);
		this.tableRegion.addMouseListener(this);
		
	}
	private Object[][] extraireRegion() 
	{
		
		ArrayList<Region> lesRegions = ModeleRegion.selectAll();
		
		Object [][]donnees = new Object[lesRegions.size()][2];
		
		int i = 0;
		
		for(Region uneRegion : lesRegions)
		{
			donnees [i][0] = uneRegion.getIdRegion();
			donnees [i][1] = uneRegion.getNomRegion();
			i++;
		}
		return donnees;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int lg = this.tableRegion.getSelectedRow();
		int ht = this.tableRegion.getSelectedColumn();
		int idReg = Integer.parseInt(this.tableRegion.getValueAt(lg, 0).toString());
		String nomR = this.tableRegion.getValueAt(lg, 1).toString();
		
		Region uneRegion = new Region(idReg, nomR);
		VueEditionRegion.remplir(uneRegion);
		
		
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
