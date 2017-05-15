package victhicompany.restline;

import java.util.Date;

/**
 * Created by thiba on 16/03/2017.
 */

public class Reservations
{
    private int idReservation, idResto, idClient;
    private String statut;
    private Date date_heure_Reservation;

    public Reservations(int idReservation, Date date_heure_Reservation, String statut, int idResto, int idClient)
    {
        this.idReservation = idReservation;
        this.date_heure_Reservation = date_heure_Reservation;
        this.statut = statut;
        this.idResto = idResto;
        this.idClient = idClient;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdResto() {
        return idResto;
    }

    public void setIdResto(int idResto) {
        this.idResto = idResto;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDate_heure_Reservation() {
        return date_heure_Reservation;
    }

    public void setDate_heure_Reservation(Date date_heure_Reservation) {
        this.date_heure_Reservation = date_heure_Reservation;
    }
}
