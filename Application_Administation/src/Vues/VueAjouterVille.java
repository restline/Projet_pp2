package Vues;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.Region;
import Controleur.Ville;
import Modele.ModeleRegion;
import Modele.ModeleVille;

public class VueAjouterVille extends JPanel implements ActionListener
{

	private JTextField cpVille = new JTextField();
	private JTextField nomVille = new JTextField();
	@SuppressWarnings("rawtypes")
	private JComboBox idRegion= new JComboBox();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Insérer");
	
	public VueAjouterVille()
	{
		this.setBounds(20, 50, 500, 150); //('', '','largeur', 'longeur')
		this.setLayout(new GridLayout(5, 2)); //colonne - ligne
		
		this.add(new JLabel("Code Postal Ville"));
		this.add(this.cpVille);
		
		this.add(new JLabel("Nom Ville"));
		this.add(this.nomVille);
		
		this.add(new JLabel("id de la Region"));
		this.add(this.idRegion);
		
		this.add(this.btAnnuler);
		this.add(this.btEnregistrer);
		
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		comboBoxidRegion();
		this.idRegion.setVisible(true);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btAnnuler)
		{
			this.nomVille.setText("");
			
		}
		else if(e.getSource() == this.btEnregistrer)
		{
			String nomVille = this.nomVille.getText();
			int id, idRegion;
			try
			{
				id = Integer.parseInt(this.cpVille.getText());
				idRegion = (int)this.idRegion.getSelectedItem();
				
				Ville uneVille = new Ville(id, nomVille, idRegion);
				ModeleVille.insert(uneVille);
				JOptionPane.showMessageDialog(this, "insertion réussie"); //message
			}
			catch(NumberFormatException exp)
			{
				
				JOptionPane.showMessageDialog(this, "insertion raté"); //message
			}
		
		}
	}
	
	@SuppressWarnings("unchecked")
	public void comboBoxidRegion()
	{
		this.idRegion.removeAll();
		
		ArrayList<Region> lesRegions = ModeleRegion.selectAll();
		
		for(Region uneRegion : lesRegions)
		{
			this.idRegion.addItem(uneRegion.getIdRegion());
		}
	}
}
