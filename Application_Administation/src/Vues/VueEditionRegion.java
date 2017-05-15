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

import Controleur.Region;
import Modele.ModeleRegion;

public class VueEditionRegion extends JPanel implements ActionListener
{
	private static JTextField idRegion = new JTextField();
	private static JTextField nomRegion = new JTextField();
	
	private JLabel idR = new JLabel("Cp de la région");
	private JLabel nomR = new JLabel("nom de la région");
	
	private JButton btMJ = new JButton(new ImageIcon("src/Images/update.png"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/Images/annuler.png"));
	private JButton btinserer = new JButton(new ImageIcon("src/Images/valider.png"));
	
	public VueEditionRegion()
	{
		this.setBounds(7, 320, 730, 122);	//('', '','largeur', 'longeur')
		this.setLayout(null);
		this.setBackground(new Color(131, 166, 151));//colonne - ligne
		
		idR.setBounds(20, 40, 100, 20);
		this.add(this.idR);
		idRegion.setBounds(140, 40, 100, 20);
		idRegion.setEditable(false);
		this.add(this.idRegion);
		
		nomR.setBounds(260, 40, 100, 20);
		this.add(this.nomR);
		nomRegion.setBounds(380, 40, 100, 20);
		this.add(this.nomRegion);
		
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
		if(e.getSource() == this.btSupprimer)
		{
			int idR = Integer.parseInt(this.idRegion.getText().toString());
			ModeleRegion.supprimer(idR);
			 JOptionPane.showMessageDialog(this, "Supression de la région réussit");
		}
		else if(e.getSource() == this.btinserer)
		{
			int idR = Integer.parseInt(this.idRegion.getText().toString());
			String nomR = this.nomRegion.getText().toString();
			
			Region uneRegion = new Region(idR, nomR);
			ModeleRegion.inserer(uneRegion);
			JOptionPane.showMessageDialog(this, "Insertion de la région réussit");
		}
		else if(e.getSource() == this.btMJ)
		{
			int idR = Integer.parseInt(this.idRegion.getText().toString());
			String nomR = this.nomRegion.getText().toString();
			
			ModeleRegion.MJ(idR, nomR);
			JOptionPane.showMessageDialog(this, "Mise a jour de la région réussit");
		}
		
	}
	
	public static void remplir(Region uneRegion)
	{
		idRegion.setText(Integer.toString(uneRegion.getIdRegion()));
		nomRegion.setText(uneRegion.getNomRegion());
	}
}
