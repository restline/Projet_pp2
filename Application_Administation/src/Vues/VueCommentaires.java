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

import Controleur.Commentaires;
import Modele.ModeleCommentaires;


public class VueCommentaires extends JPanel implements ActionListener, MouseListener
{
	
	private JLabel lbTitre = new JLabel("Liste des Commentaires");
	private JTable tableCommentaires;
	
	public VueCommentaires()
	{
		this.setBounds(50, 50, 622, 250); //fenetre restaurant (margin-left,margin top, longueur, largeur)
		this.setLayout(null); //pas de photo
		this.setBackground(new Color(130, 196, 108)); //couleur bleu marine
		this.lbTitre.setBounds(250, 10, 200, 10); //placement titre
		this.add(this.lbTitre); //ajout titre
		
		String entete [] = {"Numeros du commentaire", "auteur du commentaire", 
							"sujet du commentaire", "texte du commentaire", "Numeros du client"};
		
		this.tableCommentaires = new JTable(this.extraireCommentaires(), entete); //creation tableaux
		JScrollPane uneScroll = new JScrollPane(tableCommentaires);
		uneScroll.setBounds(10, 40, 600, 200);
		this.add(uneScroll);
		
		this.setVisible(false);
		this.tableCommentaires.addMouseListener(this);
	}
	
	private Object[][] extraireCommentaires() {
		
		ArrayList<Commentaires> lesCommentaires = ModeleCommentaires.selectAll();
		Object [][]donnees = new Object[lesCommentaires.size()][5];
		int i = 0;
		
		for(Commentaires  unCommentaire : lesCommentaires)
		{
			donnees [i][0] = unCommentaire.getIdCom();
			donnees [i][1] = unCommentaire.getAuteurCom();
			donnees [i][2] = unCommentaire.getSujetCom();
			donnees [i][3] = unCommentaire.getTexteCom();
			donnees [i][4] = unCommentaire.getIdCom();
			i++;
			
		}
		
		
		return donnees;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int lg = this.tableCommentaires.getSelectedRow();
		int ht = this.tableCommentaires.getSelectedColumn();
		int idCom = Integer.parseInt(this.tableCommentaires.getValueAt(lg, 0).toString());
		String auteurC = this.tableCommentaires.getValueAt(lg, 1).toString();
		String  sujetCom = this.tableCommentaires.getValueAt(lg, 2).toString();
		String texteCom = this.tableCommentaires.getValueAt(lg, 3).toString();
		int idClt = Integer.parseInt(this.tableCommentaires.getValueAt(lg, 4).toString());
		
		Commentaires unCommentaire = new Commentaires(idCom, auteurC, sujetCom, 
													  texteCom, idClt);
		
		VueEditionCommentaires.remplir(unCommentaire);
		
		
		
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
	public void mousePressed(MouseEvent e) {
		
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
