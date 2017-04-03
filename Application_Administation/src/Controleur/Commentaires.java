package Controleur;

public class Commentaires 
{
	private int idCom, idClient;
	private String auteurCom, sujetCom, texteCom;
	
	public Commentaires(int idCom, String auteurCom, 
						String sujetCom, String texteCom, int idClient)
	{
		this.idClient = idClient;
		this.auteurCom = auteurCom;
		this.sujetCom = sujetCom;
		this.texteCom = texteCom;
		this.idCom = idCom;
	}

	public int getIdCom() {
		return idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getAuteurCom() {
		return auteurCom;
	}

	public void setAuteurCom(String auteurCom) {
		this.auteurCom = auteurCom;
	}

	public String getSujetCom() {
		return sujetCom;
	}

	public void setSujetCom(String sujetCom) {
		this.sujetCom = sujetCom;
	}

	public String getTexteCom() {
		return texteCom;
	}

	public void setTexteCom(String texteCom) {
		this.texteCom = texteCom;
	}
	
	
}
