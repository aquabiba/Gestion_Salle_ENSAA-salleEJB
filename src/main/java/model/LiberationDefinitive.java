package model;

import jakarta.persistence.*;
@Entity
public class LiberationDefinitive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_lib_def;

    @OneToOne
    private Reservation reservation;

    @OneToOne
    private Professeur professeur;

    public LiberationDefinitive() {}

    public LiberationDefinitive(Reservation reservation, int id_lib_def,Professeur professeur) {
        this.reservation = reservation;
        this.id_lib_def = id_lib_def;
        this.professeur = professeur;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public int getId_lib_def() {
        return id_lib_def;
    }

    public void setId_lib_def(int id_lib_def) {
        this.id_lib_def = id_lib_def;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
