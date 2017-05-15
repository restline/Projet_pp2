package Vues;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.Particulier;
import Controleur.Main;
import Modele.ModeleParticulier;

public class VueEditionParticulier extends JPanel implements ActionListener
{

	private static JTextField nomClient = new JTextField();
	private static JTextField emailClient = new JTextField();
	private static JTextField numTelClient = new JTextField();
	private static JTextField cp = new JTextField();
	private static JTextField rue = new JTextField();
	private static JTextField Ville = new JTextField();
	private static JTextField mdpClient = new JTextField();
	private static JTextField prenom = new JTextField();
	

	private JLabel nomC = new JLabel("Nom du client");
	private JLabel emailC = new JLabel(" Email du Client ");
	private JLabel numTC = new JLabel(" Numero du client ");
	private JLabel cP = new JLabel(" Code Postal ");
	private JLabel R = new JLabel(" Rue ");
	private JLabel Vll = new JLabel(" Ville ");
	private JLabel mdpC = new JLabel(" Mdp Client ");
	private JLabel Pre = new JLabel(" Prenom ");
	
	
	private JButton btMJ = new JButton(new ImageIcon("src/Images/valider.png"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/Images/annuler.png"));
	
	public VueEditionParticulier()
	{
		this.setBounds(10, 320, 725, 200);	//('', '','largeur', 'longeur')
		this.setLayout(null);
		this.setBackground(new Color(131, 166, 151));//colonne - ligne
		
	
		nomC.setBounds(20, 40, 100, 20);
		this.add(this.nomC);
		nomClient.setBounds(140, 40, 100, 20);
		this.add(this.nomClient);
		
		emailC.setBounds(260, 40, 100, 20);
		this.add(this.emailC);
		emailClient.setBounds(380, 40, 100, 20);
		this.add(this.emailClient);
		
		numTC.setBounds(500, 40, 100, 20);
		this.add(this.numTC);
		numTelClient.setBounds(620, 40, 100, 20);
		this.add(this.numTelClient);
		
		cP.setBounds(20, 80, 100, 20);
		this.add(this.cP);
		cp.setBounds(140, 80, 100, 20);
		this.add(this.cp);
		
		R.setBounds(260, 80, 100, 20);
		this.add(this.R);
		rue.setBounds(380, 80, 100, 20);
		this.add(this.rue);
		
		Vll.setBounds(500, 80, 100, 20);
		this.add(this.Vll);
		Ville.setBounds(620, 80, 100, 20);
		this.add(this.Ville);
		
		mdpC.setBounds(20, 120, 100, 20);
		this.add(this.mdpC);
		mdpClient.setBounds(140, 120, 100, 20);
		this.add(this.mdpClient);
		
		Pre.setBounds(260, 120, 100, 20);
		this.add(this.Pre);
		prenom.setBounds(380, 120, 100, 20);
		this.add(this.prenom);
		
	
		btMJ.setBounds(20, 165, 40, 30);
		btMJ.setContentAreaFilled(false);
        btMJ.setBorderPainted(false);
		this.add(this.btMJ);
		btSupprimer.setBounds(70, 165, 40, 30);
		btSupprimer.setContentAreaFilled(false);
        btSupprimer.setBorderPainted(false);
		this.add(this.btSupprimer);
		
		this.btMJ.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btSupprimer) //suppression client
		{
			String nomC = nomClient.getText().toString();
			ModeleParticulier.delete(nomC);
			JOptionPane.showMessageDialog(this, "Supression du particulier réussite");
		}
		else if(e.getSource() == this.btMJ)
		{
			
			String nom = nomClient.getText().toString();
			String email = emailClient.getText().toString();
			String numeros = numTelClient.getText().toString();
			String codep = cp.getText().toString();
			String R = rue.getText().toString();
			String ville = Ville.getText().toString();
			String mdp = mdpClient.getText().toString();
			String mdpSha = Main.coderSha(mdp);
			String pre = prenom.getText().toString();
			ModeleParticulier.update(nom, email, numeros, codep, R, ville, mdp, pre);
			JOptionPane.showMessageDialog(this, "Mise à jour du particulier réussite");
		}
	}
	
	public static void remplir(Particulier unClient)
	{
		//remplis les champs
		nomClient.setText(unClient.getNomClient());
		emailClient.setText(unClient.getEmailClient());
		numTelClient.setText(unClient.getNumTelClient());
		cp.setText(unClient.getCp());
		rue.setText(unClient.getRue());
		Ville.setText(unClient.getVille());
		prenom.setText(unClient.getPrenom());
	}
	
	
}
