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

import Controleur.Main;
import Controleur.Professionnel;
import Modele.ModeleProfessionnel;

public class VueEditionProfessionnel extends JPanel implements ActionListener
{

	private static JTextField nomClient = new JTextField();
	private static JTextField emailClient = new JTextField();
	private static JTextField numTelClient = new JTextField();
	private static JTextField cp = new JTextField();
	private static JTextField rue = new JTextField();
	private static JTextField Ville = new JTextField();
	private static JTextField mdpClient = new JTextField();
	private static JTextField numSiret = new JTextField();
	private static JTextField nomContact = new JTextField();
	private static JTextField prenomContact = new JTextField();
	
	
	private JLabel nomC = new JLabel("Nom du client");
	private JLabel emailC = new JLabel(" Email du Client ");
	private JLabel numTC = new JLabel(" Numero du client ");
	private JLabel cP = new JLabel(" Code Postal ");
	private JLabel R = new JLabel(" Rue ");
	private JLabel Vll = new JLabel(" Ville ");
	private JLabel mdpC = new JLabel(" Mdp Client ");
	private JLabel nS = new JLabel(" Numeros du siret ");
	private JLabel nC = new JLabel(" Nom du Contact ");
	private JLabel pC = new JLabel(" Prenom du Contact ");
	
	private JButton btMJ = new JButton(new ImageIcon("src/Images/ajouter.jpg"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/Images/supprimer.jpg"));
	
	public VueEditionProfessionnel()
	{
		this.setBounds(10, 320, 725, 225);	//('', '','largeur', 'longeur')
		this.setLayout(null);
		this.setBackground(new Color(102, 153, 204));//colonne - ligne
		
	
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
		
		nS.setBounds(260, 120, 100, 20);
		this.add(this.nS);
		numSiret.setBounds(380, 120, 100, 20);
		this.add(this.numSiret);
		
		nC.setBounds(500, 120, 100, 20);
		this.add(this.nC);
		nomContact.setBounds(620, 120, 100, 20);
		this.add(this.nomContact);
		
		pC.setBounds(20, 160, 100, 20);
		this.add(this.pC);
		prenomContact.setBounds(140, 160, 100, 20);
		this.add(this.prenomContact);
		
		btMJ.setBounds(20, 192, 40, 30);
		this.add(this.btMJ);
		btSupprimer.setBounds(70, 192, 40, 30);
		this.add(this.btSupprimer);
		
		this.btMJ.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.setVisible(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btSupprimer )
		{
			String nomC = nomClient.getText().toString();
			ModeleProfessionnel.delete(nomC);
			JOptionPane.showMessageDialog(this, "Supression du professionnel réussite");
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
			String numS = numSiret.getText().toString();
			String nomC = nomContact.getText().toString();
			String prenomC = prenomContact.getText().toString();
			
			ModeleProfessionnel.update(nom, email, numeros, codep, R, ville, mdp, numS, nomC, prenomC);
			JOptionPane.showMessageDialog(this, "mise à jour du professionnel réussite");
		}
	}
		
		public static void remplir(Professionnel unClient) //methode remplir champs de texte
		{
			//remplis les champs
			nomClient.setText(unClient.getNomClient());
			emailClient.setText(unClient.getEmailClient());
			numTelClient.setText(unClient.getNumTelClient());
			cp.setText(unClient.getCp());
			rue.setText(unClient.getRue());
			Ville.setText(unClient.getVille());
			numSiret.setText(unClient.getNumSiret());
			nomContact.setText(unClient.getNomContact());
			prenomContact.setText(unClient.getPrenomContact());
		}
		
	

}
