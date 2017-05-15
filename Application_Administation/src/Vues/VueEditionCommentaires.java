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

import Controleur.Commentaires;
import Modele.ModeleCommentaires;

public class VueEditionCommentaires extends JPanel implements ActionListener
{
	private static JTextField idCom = new JTextField();
	private static JTextField auteurCom = new JTextField();
	private static JTextField sujetCom = new JTextField();
	private static JTextField texteCom = new JTextField();
	private static JTextField idClient = new JTextField();
	
	private JLabel idCo = new JLabel(" Numeros du commentaire");
	private JLabel autC = new JLabel(" Auteur du commentaire ");
	private JLabel sjtC = new JLabel(" Sujet du Commentaire ");
	private JLabel txtC = new JLabel(" Texte du commentaire ");
	private JLabel idClt = new JLabel(" Numeros du client ");
	
	private JButton btSupprimer = new JButton(new ImageIcon("src/Images/annuler.png"));
	private JButton rafraichir = new JButton("rafraichir");
	
	public VueEditionCommentaires()
	{
		this.setBounds(10, 320, 725, 170);	//('', '','largeur', 'longeur')
		this.setLayout(null);
		this.setBackground(new Color(131, 166, 151));//colonne - ligne
		
	
		idCo.setBounds(20, 40, 100, 20);
		this.add(this.idCo);
		idCom.setBounds(140, 40, 100, 20);
		idCom.setEditable(false);
		this.add(this.idCom);
		
		autC.setBounds(260, 40, 100, 20);
		this.add(this.autC);
		auteurCom.setBounds(380, 40, 100, 20);
		this.add(this.auteurCom);
		
	    sjtC.setBounds(500, 40, 100, 20);
		this.add(this.sjtC);
		sujetCom.setBounds(620, 40, 100, 20);
		this.add(this.sujetCom);
		
		txtC.setBounds(20, 80, 100, 20);
		this.add(this.txtC);
		texteCom.setBounds(140, 80, 100, 20);
		this.add(this.texteCom);
		
		idClt.setBounds(260, 80, 100, 20);
		this.add(this.idClt);
		idClient.setBounds(380, 80, 100, 20);
		this.add(this.idClient);
		
		btSupprimer.setBounds(20, 120, 40, 30);
		btSupprimer.setContentAreaFilled(false);
        btSupprimer.setBorderPainted(false);
		this.add(this.btSupprimer);
		
		
		
		
		
		this.btSupprimer.addActionListener(this);
		this.rafraichir.addActionListener(this);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btSupprimer)
		{
			int idC = Integer.parseInt(idCom.getText().toString());
			ModeleCommentaires.supprimer(idC);
			JOptionPane.showMessageDialog(this, "Supression du commentaire réussite");
			
		}
		else if(e.getSource() == this.rafraichir)
		{
			
		}
		
	}
	
	public static void remplir(Commentaires unCommentaire)
	{
		idCom.setText(Integer.toString(unCommentaire.getIdCom()));
		auteurCom.setText(unCommentaire.getAuteurCom());
		sujetCom.setText(unCommentaire.getSujetCom());
		texteCom.setText(unCommentaire.getTexteCom());
		idClient.setText(Integer.toString(unCommentaire.getIdClient()));
	}
	

}
