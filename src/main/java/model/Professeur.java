package model;

import jakarta.persistence.*;

@Entity
public class Professeur extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prof;
    @ManyToOne
    private Matiere matiere;

    public Professeur(String nom_Ut, String prenom_Ut, String email_Ut, String password_Ut,
                      String telephone_Ut, Matiere matiere) {
        super(nom_Ut, prenom_Ut, email_Ut, password_Ut, telephone_Ut);
        this.matiere = matiere;
    }
    

    public Professeur() {
        super();
    }
    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }
}
