package model;

import jakarta.persistence.Embeddable;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Embeddable
public class InfosRes {

    private String jour_res;
    private boolean status_res;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    public InfosRes() {}

    public InfosRes(String jour_res, LocalDate dateDebut, LocalDate dateFin) {
        this.jour_res = jour_res;
        this.status_res = true; // a la creation le status c est toujours active il sera objet de modification dans la Liberation
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }



    public String getJour_res() {
        return jour_res;
    }

    public void setJour_res(String jour_res) {
        this.jour_res = jour_res;
    }


    public boolean isStatus_res() {
        return status_res;
    }

    public void setStatus_res(boolean status_res) {
        this.status_res = status_res;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}
