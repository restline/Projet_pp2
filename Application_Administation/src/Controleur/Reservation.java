package Controleur;

import java.util.Date;


public class Reservation {
	private Date dateHeureReservation;
	private int idReservation, nbPersonnes;
	private String statut;
	public Reservation(int idReservation, Date dateHeureReservation, int nbPersonnes, String statut)
	{
		this.idReservation = idReservation;
		this.dateHeureReservation = dateHeureReservation;
		this.nbPersonnes = nbPersonnes;
		this.statut = statut;
	}
	public Date getDateHeureReservation() {
		return dateHeureReservation;
	}
	public void setDateHeureReservation(Date dateHeureReservation) {
		this.dateHeureReservation = dateHeureReservation;
	}
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	public int getNbPersonnes() {
		return nbPersonnes;
	}
	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	

	
	
}
