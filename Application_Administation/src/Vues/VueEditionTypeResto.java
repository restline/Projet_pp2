package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.TypeResto;
import Modele.ModeleTypeResto;

public class VueEditionTypeResto extends JPanel implements ActionListener 
{
	private static JTextField idTypeResto = new JTextField();
	private static JTextField libelle = new JTextField();
	private static JTextField catPrix = new JTextField();
	private static JTextField nbEtoiles = new JTextField();
	
	private JLabel idTR = new JLabel("numeros du type de restaurant");
	private JLabel lib = new JLabel("Nom du type de restaurant");
	private JLabel catP = new JLabel("catégorie du prix");
	private JLabel nbE = new JLabel("nombre d'étoile");
	
	private JButton btMJ = new JButton(new ImageIcon("src/Images/mj.jpg"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/Images/supprimer.jpg"));
	private JButton btinserer = new JButton(new ImageIcon("src/Images/ajouter.jpg"));
	private JButton btnRafraichir = new JButton("rafraichir");
	
	public VueEditionTypeResto()
	{
		this.setBounds(7, 320, 730, 225);	//('', '','largeur', 'longeur')
		this.setLayout(null);
		this.setBackground(new Color(102, 153, 204));//colonne - ligne
		
		idTR.setBounds(20, 40, 100, 20);
		this.add(this.idTR);
		idTypeResto.setBounds(140, 40, 100, 20);
		idTypeResto.setEditable(false);
		this.add(this.idTypeResto);
		
		lib.setBounds(260, 40, 100, 20);
		this.add(this.lib);
		libelle.setBounds(380, 40, 100, 20);
		this.add(this.libelle);
		
		catP.setBounds(500, 40, 100, 20);
		this.add(this.catP);
		catPrix.setBounds(620, 40, 100, 20);
		this.add(this.catPrix);
		
		nbE.setBounds(20, 80, 100, 20);
		this.add(this.nbE);
		nbEtoiles.setBounds(140, 80, 100, 20);
		this.add(this.nbEtoiles);
		

		this.btinserer.setBounds(20, 120, 40, 30);
		this.add(this.btinserer);
		btMJ.setBounds(70, 120, 40, 30);
		this.add(this.btMJ);
		btSupprimer.setBounds(120, 120, 40, 30);
		this.add(this.btSupprimer);
		this.btnRafraichir.setBounds(520, 120, 100, 20);
		this.add(this.btnRafraichir);
		
		this.btMJ.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btinserer.addActionListener(this);
		this.btnRafraichir.addActionListener(this);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.btSupprimer)
		{
			int idTypeResto = Integer.parseInt(this.idTypeResto.getText().toString());
			ModeleTypeResto.supprimer(idTypeResto);
			JOptionPane.showMessageDialog(this, "Supression du type de restaurant réussit");
		}
		else if(e.getSource() == this.btinserer)
		{
			int idTR = Integer.parseInt(this.idTypeResto.getText().toString());
			String lib = this.libelle.getText().toString();
			String catP = this.catPrix.getText().toString();
			int nbE = Integer.parseInt(this.nbEtoiles.getText().toString());
			
			TypeResto unTypeResto = new TypeResto(idTR, lib, catP, nbE);
			ModeleTypeResto.inserer(unTypeResto);
			JOptionPane.showMessageDialog(this, "insertion du type de restaurant réussit");
		}
		else if(e.getSource() == this.btMJ)
		{
			int idTR = Integer.parseInt(this.idTypeResto.getText().toString());
			String lib = this.libelle.getText().toString();
			String catP = this.catPrix.getText().toString();
			int nbE = Integer.parseInt(this.nbEtoiles.getText().toString());
			
			ModeleTypeResto.MJ(idTR, lib, catP, nbE);
			JOptionPane.showMessageDialog(this, "Mise à jour du restaurant réussit");
		}
		else if(e.getSource() == this.btnRafraichir)
		{
			
			JOptionPane.showMessageDialog(this, "Tableaux rafraichit");
		}
		
	}
	
	public static void remplir(TypeResto unTypeResto)
	{
		idTypeResto.setText(Integer.toString(unTypeResto.getIdTypeResto()));
		libelle.setText(unTypeResto.getLibelle());
		catPrix.setText(unTypeResto.getCatPrix());
		nbEtoiles.setText(Integer.toString(unTypeResto.getNbEtoiles()));
	}

}
