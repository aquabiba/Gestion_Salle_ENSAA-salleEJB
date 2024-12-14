package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class LiberationDefinitive extends Liberation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_lib_def;
    private LocalDate date_lib_def;

    @OneToOne
    private Reservation reservation;

    @ManyToOne
    private Professeur professeur;

    public LiberationDefinitive() {}

    public LiberationDefinitive(String libele,LocalDate date_lib_def,Reservation reservation, Professeur professeur) {
        super(libele);
        this.reservation = reservation;
        this.professeur = professeur;
        this.date_lib_def = date_lib_def;
    }

    public LocalDate getDate_lib_def() {
        return date_lib_def;
    }

    public void setDate_lib_def(LocalDate date_lib_def) {
        this.date_lib_def = date_lib_def;
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
