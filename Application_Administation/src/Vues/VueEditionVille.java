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

import Controleur.Ville;
import Modele.ModeleVille;

public class VueEditionVille extends JPanel implements ActionListener
{
	
	private static JTextField idVille = new JTextField();
	private static JTextField nomVille = new JTextField();
	private static JTextField idRegion = new JTextField();
	
	private JLabel idV = new JLabel("numeros de la ville");
	private JLabel nomV = new JLabel(" nom de la ville ");
	private JLabel idReg = new JLabel(" code postal region");
	
	private JButton btMJ = new JButton(new ImageIcon("src/Images/update.png"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/Images/annuler.png"));
	private JButton btinserer = new JButton(new ImageIcon("src/Images/valider.png"));
	
	public VueEditionVille()
	{
		this.setBounds(7, 320, 730, 122);	//('', '','largeur', 'longeur')
		this.setLayout(null);
		this.setBackground(new Color(131, 166, 151));//colonne - ligne
		
		idV.setBounds(20, 40, 100, 20);
		this.add(this.idV);
		idVille.setBounds(140, 40, 100, 20);
		this.add(this.idVille);
		
		nomV.setBounds(260, 40, 100, 20);
		this.add(this.nomV);
		nomVille.setBounds(380, 40, 100, 20);
		this.add(this.nomVille);
		
		idReg.setBounds(500, 40, 100, 20);
		this.add(this.idReg);
		idRegion.setBounds(620, 40, 100, 20);
		this.add(this.idRegion);
		
		btinserer.setBounds(20, 80, 40, 30);
		this.add(this.btinserer);
		btMJ.setBounds(70, 80, 40, 30);
		this.add(this.btMJ);
		btSupprimer.setBounds(120, 80, 40, 30);
		this.add(this.btSupprimer);
		
		this.btinserer.addActionListener(this);
		btinserer.setContentAreaFilled(false);
        btinserer.setBorderPainted(false);
		this.btMJ.addActionListener(this);
		btMJ.setContentAreaFilled(false);
        btMJ.setBorderPainted(false);
		this.btSupprimer.addActionListener(this);
		btSupprimer.setContentAreaFilled(false);
        btSupprimer.setBorderPainted(false);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btSupprimer)
		{
			 int idV = Integer.parseInt(this.idVille.getText().toString());
			 ModeleVille.supprimmer(idV);
			 JOptionPane.showMessageDialog(this, "Supression de la ville réussit");
		}
		else if(e.getSource() == this.btinserer)
		{
			int cpV = Integer.parseInt(this.idVille.getText().toString());
			String nomV = this.nomVille.getText().toString();
			int idR = Integer.parseInt(this.idRegion.getText().toString());
			
			Ville uneVille = new Ville(cpV, nomV, idR);
			ModeleVille.inserer(uneVille);
			JOptionPane.showMessageDialog(this, "Insertion de la ville réussit");
		}
		else if(e.getSource() == this.btMJ)
		{
			int cpV = Integer.parseInt(this.idVille.getText().toString());
			String nomV = this.nomVille.getText().toString();
			int idR = Integer.parseInt(this.idRegion.getText().toString());
			
			ModeleVille.MJ(cpV, nomV, idR);
			JOptionPane.showMessageDialog(this, "Mise à jour de la ville réussit");
		}
		
	}
	public static void remplir(Ville uneVille)
	{
		idVille.setText(Integer.toString(uneVille.getCpVille()));
		nomVille.setText(uneVille.getNomVille());
		idRegion.setText(Integer.toString(uneVille.getIdRegion()));
	}

}
