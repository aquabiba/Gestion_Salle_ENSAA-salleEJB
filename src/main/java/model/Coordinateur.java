package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Coordinateur extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_coord;

    @OneToMany(mappedBy = "Coordinateur")
    private List<Filiere> filiere;

    @OneToMany(mappedBy = "Coordinateur")
    private List<Emploi> emploi;

    @OneToMany(mappedBy = "Coordinateur")
    private List<Matiere> matiere;
    public Coordinateur(String nom_Ut, String prenom_Ut, String email_Ut,
                        String password_Ut, String telephone_Ut, int id_coord) {
        super(nom_Ut, prenom_Ut, email_Ut, password_Ut, telephone_Ut);
        this.id_coord = id_coord;

    }

    public Coordinateur() {
        super();
    }

    @Override
    public String toString() {
        return "Coordinateur{" +super.toString() + "id_coord=" + id_coord + super.toString()+"}";

    }

    public List<Filiere> getFiliere() {
        return filiere;
    }

    public void setFiliere(List<Filiere> filiere) {
        this.filiere = filiere;
    }

    public List<Emploi> getEmploi() {
        return emploi;
    }

    public void setEmploi(List<Emploi> emploi) {
        this.emploi = emploi;
    }

    public List<Matiere> getMatiere() {
        return matiere;
    }

    public void setMatiere(List<Matiere> matiere) {
        this.matiere = matiere;
    }

    public int getId_coord() {
        return id_coord;
    }

    public void setId_coord(int id_coord) {
        this.id_coord = id_coord;
    }


}
