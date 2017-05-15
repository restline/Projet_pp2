package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.Restaurant;
import Modele.ModeleRestaurant;

public class VueEditionRestaurant  extends JPanel implements ActionListener 
{
	private static JTextField idResto = new JTextField();
	private static JTextField nomResto = new JTextField();
	private static JTextField nbTables = new JTextField();
	private static JTextField nbCouverts = new JTextField();
	private static JTextField telResto = new JTextField();
	private static JTextField heureOuv = new JTextField();
	private static JTextField heureFer = new JTextField();
	private static JTextField ferExceptionelle = new JTextField();
	private static JTextField imageResto = new JTextField();
	private static JTextField idTypeRestaurant = new JTextField();
	private static JTextField cpVille = new JTextField();
	
	
	private JLabel idR = new JLabel("numeros du restaurant");
	private JLabel nomR = new JLabel("Nom du Restaurant");
	private JLabel nbT = new JLabel("Nombre de table");
	private JLabel nbC = new JLabel("Nombre de couvert");
	private JLabel telR = new JLabel("telephone du restaurant");
	private JLabel heureO = new JLabel("heure d'ouverture");
	private JLabel heureF = new JLabel("heure de fermeture");
	private JLabel FerExc = new JLabel("Fermeture exceptionelle");
	private JLabel imageR = new JLabel("lien de l'image du restaurant");
	private JLabel idTR = new JLabel("Type du restaurant");
	private JLabel cpV = new JLabel("code postal de la ville du restaurant");
	
	private JButton btMJ = new JButton(new ImageIcon("src/Images/update.png"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/Images/annuler.png"));
	private JButton btinserer = new JButton(new ImageIcon("src/Images/valider.png"));
	
	public VueEditionRestaurant()
	{
		this.setBounds(7, 320, 730, 225);	//('', '','largeur', 'longeur')
		this.setLayout(null);
		this.setBackground(new Color(131, 166, 151));//colonne - ligne
		
		idR.setBounds(20, 40, 100, 20);
		this.add(this.idR);
		idResto.setBounds(140, 40, 100, 20);
		idResto.setEditable(false);
		this.add(this.idResto);
		
		nomR.setBounds(260, 40, 100, 20);
		this.add(this.nomR);
		nomResto.setBounds(380, 40, 100, 20);
		this.add(this.nomResto);
		
		nbT.setBounds(500, 40, 100, 20);
		this.add(this.nbT);
		nbTables.setBounds(620, 40, 100, 20);
		this.add(this.nbTables);
		
		nbC.setBounds(20, 80, 100, 20);
		this.add(this.nbC);
		nbCouverts.setBounds(140, 80, 100, 20);
		this.add(this.nbCouverts);
		
		telR.setBounds(260, 80, 100, 20);
		this.add(this.telR);
		telResto.setBounds(380, 80, 100, 20);
		this.add(this.telResto);
		
		heureO.setBounds(500, 80, 100, 20);
		this.add(this.heureO);
		heureOuv.setBounds(620, 80, 100, 20);
		this.add(this.heureOuv);
		
		heureF.setBounds(20, 120, 100, 20);
		this.add(this.heureF);
		heureFer.setBounds(140, 120, 100, 20);
		this.add(this.heureFer);
		
		FerExc.setBounds(260, 120, 100, 20);
		this.add(this.FerExc);
		ferExceptionelle.setBounds(380, 120, 100, 20);
		this.add(this.ferExceptionelle);
		
		imageR.setBounds(500, 120, 100, 20);
		this.add(this.imageR);
		imageResto.setBounds(620, 120, 100, 20);
		this.add(this.imageResto);
		
		idTR.setBounds(20, 160, 100, 20);
		this.add(this.idTR);
		idTypeRestaurant.setBounds(140, 160, 100, 20);
		this.add(this.idTypeRestaurant);
		
		cpV.setBounds(260, 160, 100, 20);
		this.add(this.cpV);
		cpVille.setBounds(380, 160, 100, 20);
		this.add(this.cpVille);
		
		btinserer.setBounds(20, 192, 40, 30);
		this.add(this.btinserer);
		btMJ.setBounds(70, 192, 40, 30);
		this.add(this.btMJ);
		btSupprimer.setBounds(120, 192, 40, 30);
		this.add(this.btSupprimer);
		
		this.btMJ.addActionListener(this);
		btMJ.setContentAreaFilled(false);
        btMJ.setBorderPainted(false);
		this.btSupprimer.addActionListener(this);
		btSupprimer.setContentAreaFilled(false);
        btSupprimer.setBorderPainted(false);
		this.btinserer.addActionListener(this);
		btinserer.setContentAreaFilled(false);
        btinserer.setBorderPainted(false);
		this.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this.btSupprimer) // si on clique sur le bouton supprimer
		{
			int idR = Integer.parseInt(this.idResto.getText().toString());
			ModeleRestaurant.supprimer(idR);
			JOptionPane.showMessageDialog(this, "Supression du restaurant réussite");
		}
		else if(e.getSource() == this.btinserer) //si on clique sur le bouton insérer
		{
			String nomResto = this.nomResto.getText().toString();
			int nbTables = Integer.parseInt(this.nbTables.getText().toString());
			int nbCouverts = Integer.parseInt(this.nbCouverts.getText().toString());
			String telResto = this.telResto.getText().toString();
			Time heureOuv = Time.valueOf(this.heureOuv.getText().toString());
			Time heureFer = Time.valueOf(this.heureOuv.getText().toString());
			String ferExceptionelle = this.ferExceptionelle.getText().toString();
			String imageResto = this.imageResto.getText().toString();
			int idTypeResto = Integer.parseInt(this.idTypeRestaurant.getText().toString());
			int cpVille = Integer.parseInt(this.cpVille.getText().toString());
			
			Restaurant unRestaurant = new Restaurant(0, nomResto, nbTables, nbCouverts, telResto,
			heureOuv, heureFer, ferExceptionelle, imageResto, idTypeResto, cpVille);
			
			ModeleRestaurant.inserer(unRestaurant);;
			JOptionPane.showMessageDialog(this, "Insertion du Restaurant réussit");
			
		}
		else if(e.getSource() == this.btMJ) //si on clique sur le bouton mise à jour
		{
			int idResto = Integer.parseInt(this.idResto.getText().toString());
			String nomR = this.nomResto.getText().toString();
			int nbT = Integer.parseInt(this.nbTables.getText().toString());
			int nbC = Integer.parseInt(this.nbCouverts.getText().toString());
			String telR = this.telResto.getText().toString();
			Time heureO = Time.valueOf(this.heureOuv.getText().toString());
			Time heureF = Time.valueOf(this.heureOuv.getText().toString());
			String ferExc = this.ferExceptionelle.getText().toString();
			String imageR = this.imageResto.getText().toString();
			int idTR = Integer.parseInt(this.idTypeRestaurant.getText().toString());
			int cpV = Integer.parseInt(this.cpVille.getText().toString());
			
			ModeleRestaurant.Mj(idResto, nomR, nbT, nbC, telR, heureO,heureF, ferExc, imageR, idTR, cpV);
			JOptionPane.showMessageDialog(this, "Mise à Jour du Restaurant réussit");
		}
		
	}
	public static void remplir(Restaurant unRestaurant) //methode pour remplir les champs de texte
	{
		idResto.setText(Integer.toString(unRestaurant.getIdResto()));
		nomResto.setText(unRestaurant.getNomResto());
		nbTables.setText(Integer.toString(unRestaurant.getNbTables()));
		nbCouverts.setText(Integer.toString(unRestaurant.getNbCouverts()));
		telResto.setText(unRestaurant.getTelResto());
		heureOuv.setText(unRestaurant.getHeureOuv().toString());
		heureFer.setText(unRestaurant.getHeureFer().toString());
		ferExceptionelle.setText(unRestaurant.getFerExceptionelle().toString());
		imageResto.setText(unRestaurant.getImageResto().toString());
		idTypeRestaurant.setText(Integer.toString(unRestaurant.getTypeResto()));
		cpVille.setText(Integer.toString(unRestaurant.getCpVille()));
		
		
	}
	
}
