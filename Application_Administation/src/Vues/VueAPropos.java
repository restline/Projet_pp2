package Vues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VueAPropos extends JPanel implements ActionListener
{
	private JTextArea txtInfos = new JTextArea();
	
	public VueAPropos()
	{
		this.setBounds(200, 200, 350, 40);
		this.setLayout(null);
		this.setBackground(new Color(102, 153, 204));
		this.txtInfos.setBounds(35, 10, 285, 25);
		this.txtInfos.setEditable(false);
		
		String txtInf = " Logiciel d'administration pour les Services Restline";
		
		this.txtInfos.setText(txtInf);
		this.add(this.txtInfos);
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
