package model;

import jakarta.persistence.*;
@Entity
public class LiberationExceptionnelle extends Liberation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_lib_exe;

    @OneToOne
    private Reservation reservation;

    @OneToOne
    private Professeur professeur;
    public LiberationExceptionnelle(){}

    public LiberationExceptionnelle(int id_lib_exe, Reservation reservation, Professeur professeur ) {
        this.id_lib_exe = id_lib_exe;
        this.reservation = reservation;
        this.professeur = professeur;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public int getId_lib_exe() {
        return id_lib_exe;
    }

    public void setId_lib_exe(int id_lib_exe) {
        this.id_lib_exe = id_lib_exe;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
