package Vues;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.TypeResto;
import Modele.ModeleTypeResto;

public class VueAjouterTypeResto extends JPanel implements ActionListener
{
	private int id;
	private JTextField Libelle = new JTextField();
	private JTextField catPrix = new JTextField();
	private JTextField nbEtoiles = new JTextField();
	
	//bouton

	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Insérer");
	
	public VueAjouterTypeResto()
	{
		this.setBounds(20, 50, 500, 150); //('', '','largeur', 'longeur')
		this.setLayout(new GridLayout(5, 2)); //colonne - ligne
		
		//ajout label et bouton sur fenêtre
		
		this.add(new JLabel("Libelle du Type de Resto "));
		this.add(this.Libelle);
		
		this.add(new JLabel("Catégories du Prix"));
		this.add(this.catPrix);
		
		this.add(new JLabel("Nombre d'étoiles"));
		this.add(this.nbEtoiles);
		
		this.add(this.btAnnuler);
		this.add(this.btEnregistrer);
		
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this); //ActionListener : evenement cliquable
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btAnnuler)
		{
			this.Libelle.setText("");
			this.catPrix.setText("");
			this.nbEtoiles.setText("");
			
		}
		else if(e.getSource() == this.btEnregistrer)
		{
			String Libelle = this.Libelle.getText();
			String catPrix = this.catPrix.getText();
			int id, nbEtoiles;
			
			try
			{
				id = this.id;
				nbEtoiles = Integer.parseInt(this.nbEtoiles.getText());
				TypeResto unTypeResto = new TypeResto(id, Libelle, catPrix, nbEtoiles);
				ModeleTypeResto.insert(unTypeResto);
				JOptionPane.showMessageDialog(this, "insertion réussie"); //message
			}
			catch(NumberFormatException exp)
			{
				
				JOptionPane.showMessageDialog(this, "insertion raté"); //message
			}
		}
		
	}
	
	
}
