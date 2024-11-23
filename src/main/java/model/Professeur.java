package model;

import jakarta.persistence.*;

@Entity
public class Professeur extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prof;
    @ManyToOne
    private Matiere matiere;



    public Professeur(String N, String P, String email, String pwd, String Tel, int id_prof) {
        super(N,P,email,pwd,Tel);
        this.id_prof = id_prof;
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
