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

import Controleur.TypeResto;
import Modele.ModeleTypeResto;

public class VueTypeResto extends JPanel implements ActionListener, MouseListener
{
	private JLabel lbTitre = new JLabel("Liste des Types de Restaurants");
	private JTable tableTypeRestaurants;
	
	public VueTypeResto()
	{
		this.setBounds(50, 50, 650, 250); //fenetre restaurant (margin-left,margin top, longueur, largeur)
		this.setLayout(null); //pas de photo
		this.setBackground(new Color(102, 153, 204)); //couleur bleu marine
		this.lbTitre.setBounds(150, 10, 200, 10); //placement titre
		this.add(this.lbTitre); //ajout titre
		
		//entete tableau
		String entete [] = {"id","libelle","categorie prix", "nbEtoiles"};
		
		this.tableTypeRestaurants = new JTable(this.extraireTypeRestaurants(), entete); //creation tableaux
		JScrollPane uneScroll = new JScrollPane(tableTypeRestaurants);
		uneScroll.setBounds(10, 40, 600, 200);
		this.add(uneScroll);
		
		this.setVisible(false);
		this.tableTypeRestaurants.addMouseListener(this);
		
	}
	
	private Object[][] extraireTypeRestaurants() {
		
		ArrayList<TypeResto> lesTypesRestos = ModeleTypeResto.selectAll();
		Object [][]donnees = new Object[lesTypesRestos.size()][4];
		int i = 0;
		
		for(TypeResto unTypeResto : lesTypesRestos)
		{
			donnees [i][0] = unTypeResto.getIdTypeResto();
			donnees [i][1] = unTypeResto.getLibelle();
			donnees [i][2] = unTypeResto.getCatPrix();
			donnees [i][3] = unTypeResto.getNbEtoiles();
			i++;
		}
		return donnees;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int lg = this.tableTypeRestaurants.getSelectedRow();
		int ht = this.tableTypeRestaurants.getSelectedColumn();
		int idTR = Integer.parseInt(this.tableTypeRestaurants.getValueAt(lg, 0).toString());
		String lib = this.tableTypeRestaurants.getValueAt(lg, 1).toString();
		String catP = this.tableTypeRestaurants.getValueAt(lg, 2).toString();
		int nbE = Integer.parseInt(this.tableTypeRestaurants.getValueAt(lg, 3).toString());
		
		TypeResto unTypeResto = new TypeResto(idTR, lib, catP, nbE);
		VueEditionTypeResto.remplir(unTypeResto);
		
		
		
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
