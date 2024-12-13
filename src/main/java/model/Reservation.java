package model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_res;
    @Embedded
    private InfosRes infos_res;

    @ManyToOne
    private Filiere filiere;

    @ManyToOne
    private Professeur professeur;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<LiberationExceptionnelle> liberationT;

    @ManyToOne
    private Creneau creneau;

    public Reservation() {
    }

    public Reservation(Filiere filiere, InfosRes infos_res, Professeur professeur, Creneau creneau) {
        this.filiere = filiere;
        this.infos_res = infos_res;
        this.professeur = professeur;
        this.creneau = creneau;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    public InfosRes getInfos_res() {
        return infos_res;
    }

    public void setInfos_res(InfosRes infos_res) {
        this.infos_res = infos_res;
    }

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }


    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public List<LiberationExceptionnelle> getLiberationT() {
        return liberationT;
    }

    public void setLiberationT(List<LiberationExceptionnelle> liberationT) {
        this.liberationT = liberationT;
    }



}
