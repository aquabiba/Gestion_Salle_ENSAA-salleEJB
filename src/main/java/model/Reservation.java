package model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_res;
    private Time crenaux_res;
    private Date date_res;

    @OneToOne
    private Salle salle;

    @OneToOne
    private Filiere filiere;

    @OneToOne
    private Professeur professeur;

    @OneToMany(mappedBy = "Reservation", cascade = CascadeType.ALL)
    private List<LiberationExceptionnelle> liberationT;

    @OneToOne
    private LiberationDefinitive liberationD;

    public Reservation() {
    }

    public Reservation(Time crenaux_res, Date date_res, Salle salle,
                       Filiere filiere, Professeur professeur, List<LiberationExceptionnelle> liberationT,
                       LiberationDefinitive liberationD) {
        this.crenaux_res = crenaux_res;
        this.date_res = date_res;
        this.salle = salle;
        this.filiere = filiere;
        this.professeur = professeur;
        this.liberationT = liberationT;
        this.liberationD = liberationD;
    }

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public Time getCrenaux_res() {
        return crenaux_res;
    }

    public void setCrenaux_res(Time crenaux_res) {
        this.crenaux_res = crenaux_res;
    }

    public Date getDate_res() {
        return date_res;
    }

    public void setDate_res(Date date_res) {
        this.date_res = date_res;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public List<LiberationExceptionnelle> getLiberationT() {
        return liberationT;
    }

    public void setLiberationT(List<LiberationExceptionnelle> liberationT) {
        this.liberationT = liberationT;
    }

    public LiberationDefinitive getLiberationD() {
        return liberationD;
    }

    public void setLiberationD(LiberationDefinitive liberationD) {
        this.liberationD = liberationD;
    }
}
