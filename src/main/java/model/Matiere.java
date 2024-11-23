package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mat;
    private String libelle_mat;
    private int nombreHeur_mat;

    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    private List<Professeur> professeurs ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Coordinateur coord;

    public Matiere(String libelle_mat, int nombreHeur_mat, List<Professeur> professeurs, Coordinateur coordinateur) {
        this.libelle_mat = libelle_mat;
        this.nombreHeur_mat = nombreHeur_mat;
        this.professeurs = professeurs;
        this.coord = coordinateur;
    }
    public Matiere() {}

    @Override
    public String toString() {
        return "Matiere{" +
                "id_mat=" + id_mat +
                ", libelle_mat='" + libelle_mat + '\'' +
                ", nombreHeur_mat=" + nombreHeur_mat +
                ", professeurs=" + professeurs +
                ", coordinateur=" + coord +
                '}';
    }

    public int getId_mat() {
        return id_mat;
    }

    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    public String getLibelle_mat() {
        return libelle_mat;
    }

    public void setLibelle_mat(String libelle_mat) {
        this.libelle_mat = libelle_mat;
    }

    public int getNombreHeur_mat() {
        return nombreHeur_mat;
    }

    public void setNombreHeur_mat(int nombreHeur_mat) {
        this.nombreHeur_mat = nombreHeur_mat;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    public Coordinateur getCoordinateur() {
        return coord;
    }

    public void setCoordinateur(Coordinateur coordinateur) {
        this.coord = coordinateur;
    }


}
