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
    private String niveau_fil;

    @ManyToOne
    private Coordinateur coord;
    @OneToMany(mappedBy = "filiere",cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Filiere(String libelle_fil, String niveau_fil ,int effectif_fil, Coordinateur coordinateur) {
        this.libelle_fil = libelle_fil;
        this.niveau_fil = niveau_fil;
        this.effectif_fil = effectif_fil;
        this.coord = coordinateur;
    }

    public Filiere() {
    }

    public String getNiveau_fil() {
        return niveau_fil;
    }

    public void setNiveau_fil(String niveau_fil) {
        this.niveau_fil = niveau_fil;
    }

    public Coordinateur getCoord() {
        return coord;
    }

    public void setCoord(Coordinateur coord) {
        this.coord = coord;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
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
