package Controleur;

import java.sql.Time;

public class Restaurant {
	private int idResto;
	private String nomResto, imageResto, telResto, ferExceptionelle;
	private Time heureOuv, heureFer;
	private int nbTables, nbCouverts, typeResto, cpVille;	
	
	public Restaurant(int idResto, String nomResto, int nbTables, int nbCouverts,
					  String telResto, Time heureOuv, Time heureFer, String ferExceptionelle,
					  String imageResto,int idTypeResto, int cpVille)
	{
		
		//initialisation attributs
		
		this.idResto = idResto;
		this.nomResto = nomResto;
		this.nbTables = nbTables;
		this.nbCouverts = nbCouverts;
		this.telResto = telResto;
		this.heureOuv = heureOuv;
		this.heureFer = heureFer;
		this.ferExceptionelle = ferExceptionelle;
		this.imageResto = imageResto;
		this.typeResto = idTypeResto;
		this.cpVille = cpVille;
	}
	
	//getter et setter
	
	public int getIdResto() {
		return idResto;
	}

	public void setIdResto(int idResto) {
		this.idResto = idResto;
	}

	public String getNomResto() {
		return nomResto;
	}

	public void setNomResto(String nomResto) {
		this.nomResto = nomResto;
	}

	public String getImageResto() {
		return imageResto;
	}

	public void setImageResto(String imageResto) {
		this.imageResto = imageResto;
	}

	public String getTelResto() {
		return telResto;
	}

	public void setTelResto(String telResto) {
		this.telResto = telResto;
	}

	public String getFerExceptionelle() {
		return ferExceptionelle;
	}

	public void setFerExceptionelle(String ferExceptionelle) {
		this.ferExceptionelle = ferExceptionelle;
	}

	public Time getHeureOuv() {
		return heureOuv;
	}

	public void setHeureOuv(Time heureOuv) {
		this.heureOuv = heureOuv;
	}

	public Time getHeureFer() {
		return heureFer;
	}

	public void setHeureFer(Time heureFer) {
		this.heureFer = heureFer;
	}

	public int getNbTables() {
		return nbTables;
	}

	public void setNbTables(int nbTables) {
		this.nbTables = nbTables;
	}

	public int getNbCouverts() {
		return nbCouverts;
	}

	public void setNbCouverts(int nbCouverts) {
		this.nbCouverts = nbCouverts;
	}

	public int getTypeResto() {
		return typeResto;
	}

	public void setTypeResto(int typeResto) {
		this.typeResto = typeResto;
	}

	public int getCpVille() {
		return cpVille;
	}

	public void setCpVille(int cpVille) {
		this.cpVille = cpVille;
	}
	
	


	
	
}
