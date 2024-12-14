package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class LiberationExceptionnelle extends Liberation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_lib_exe;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ManyToOne
    private Reservation reservation;

    @ManyToOne
    private Professeur professeur;

    public LiberationExceptionnelle(){
        super();
    }

    public LiberationExceptionnelle(String Libelle, LocalDate dateDebut, LocalDate dateFin, Reservation reservation, Professeur professeur) {
        super(Libelle);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.reservation = reservation;
        this.professeur = professeur;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
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
