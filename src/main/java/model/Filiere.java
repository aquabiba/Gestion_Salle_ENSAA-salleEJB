package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fil;
    private String libelle_fil;
    private int effectif_fil;

    @ManyToOne
    private Coordinateur coord;
    @OneToMany(mappedBy = "filiere",cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Filiere(String libelle_fil, int effectif_fil, Coordinateur coordinateur, List<Reservation> reservation) {
        this.libelle_fil = libelle_fil;
        this.effectif_fil = effectif_fil;
        this.coord = coordinateur;
        this.reservations = reservation;
    }

    public Filiere() {
    }

    public int getId_fil() {
        return id_fil;
    }

    public void setId_fil(int id_fil) {
        this.id_fil = id_fil;
    }

    public String getLibelle_fil() {
        return libelle_fil;
    }

    public void setLibelle_fil(String libelle_fil) {
        this.libelle_fil = libelle_fil;
    }

    public int getEffectif_fil() {
        return effectif_fil;
    }

    public void setEffectif_fil(int effectif_fil) {
        this.effectif_fil = effectif_fil;
    }

    public Coordinateur getCoordinateur() {
        return coord;
    }

    public void setCoordinateur(Coordinateur coordinateur) {
        this.coord = coordinateur;
    }

    public List<Reservation> getReservation() {
        return reservations;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservations = reservation;
    }
}
