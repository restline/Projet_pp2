package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controleur.Profil;

public class VueAccueil extends JPanel implements ActionListener
{

	private JTextArea txtInfos = new JTextArea();

	
	public  VueAccueil(Profil unProfil) {
		this.setBounds(50, 50, 300, 200);
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		this.txtInfos.setBounds(30, 30, 150, 150);
		this.txtInfos.setEditable(false); //edition non disponible
		
		String infos ="\n ----------------------\n";
		infos +="\nNom : "+unProfil.getNom();
		infos += "\nPrénoms : "+unProfil.getPrenom();
		infos += "\nEmail : "+unProfil.getEmail();
		infos += "\n-----------------------------\n";
		this.txtInfos.setText(infos);
		this.add(this.txtInfos);
		
		this.setVisible(true);
		
	} 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}	
	

}
