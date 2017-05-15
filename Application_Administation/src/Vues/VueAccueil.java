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
		this.setBounds(50, 50, 220, 150);
		this.setLayout(null);
		this.setBackground(new Color(102, 153, 204));
		this.txtInfos.setBounds(35, 15, 150, 120);
		this.txtInfos.setEditable(false); //edition non disponible
		
		String infos ="\n-----------------------------\n";
		infos +="\n Nom : "+unProfil.getNom();
		infos += "\n Prénoms : "+unProfil.getPrenom();
		infos += "\n Email : "+unProfil.getEmail();
		infos += "\n-----------------------------\n";
		this.txtInfos.setText(infos);
		this.add(this.txtInfos);
		
		this.setVisible(true);
		
	} 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}	
	

}
