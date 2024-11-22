package model;

import jakarta.persistence.Embeddable;

import java.sql.Time;
import java.util.Date;

@Embeddable
public class InfosRes {
    private Time crenaux_res;
    private String jour_res;
    private String sujet;
    private boolean status_res;
    private Date dateDebut;
    private Date dateFin;
    public InfosRes() {}

    public InfosRes(Time crenaux_res, String jour_res, String sujet, boolean status_res, Date dateDebut, Date dateFin) {
        this.crenaux_res = crenaux_res;
        this.jour_res = jour_res;
        this.sujet = sujet;
        this.status_res = status_res;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Time getCrenaux_res() {
        return crenaux_res;
    }

    public void setCrenaux_res(Time crenaux_res) {
        this.crenaux_res = crenaux_res;
    }

    public String getJour_res() {
        return jour_res;
    }

    public void setJour_res(String jour_res) {
        this.jour_res = jour_res;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public boolean isStatus_res() {
        return status_res;
    }

    public void setStatus_res(boolean status_res) {
        this.status_res = status_res;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
