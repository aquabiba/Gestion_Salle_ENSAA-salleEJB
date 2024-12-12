package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professeur extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prof;

    @ManyToOne
    private Matiere matiere;

    @OneToMany(mappedBy = "professeur")
    private List<LiberationDefinitive> liberationDefinitive;

    @OneToMany(mappedBy = "professeur")
    private List<LiberationExceptionnelle> liberationExceptionnelles;

    @OneToMany(mappedBy = "professeur")
    private List<Reservation> reservations;


    public Professeur(String nom_Ut, String prenom_Ut, String email_Ut, String password_Ut,
                      String telephone_Ut, Matiere matiere) {
        super(nom_Ut, prenom_Ut, email_Ut, password_Ut, telephone_Ut);
        this.matiere = matiere;
    }
    

    public Professeur() {
        super();
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<LiberationDefinitive> getLiberationDefinitive() {
        return liberationDefinitive;
    }

    public void setLiberationDefinitive(List<LiberationDefinitive> liberationDefinitive) {
        this.liberationDefinitive = liberationDefinitive;
    }

    public List<LiberationExceptionnelle> getLiberationExceptionnelles() {
        return liberationExceptionnelles;
    }

    public void setLiberationExceptionnelles(List<LiberationExceptionnelle> liberationExceptionnelles) {
        this.liberationExceptionnelles = liberationExceptionnelles;
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
