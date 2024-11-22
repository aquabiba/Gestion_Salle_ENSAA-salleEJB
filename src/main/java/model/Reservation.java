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
    @OneToOne
    private Salle salle;

    @OneToOne
    private Filiere filiere;

    @OneToOne
    private Professeur professeur;

    @OneToMany(mappedBy = "Reservation", cascade = CascadeType.ALL)
    private List<LiberationExceptionnelle> liberationT;

    @OneToOne
    private LiberationDefinitive liberationD;

    public Reservation() {
    }

    public Reservation(InfosRes infos_res, Salle salle, Filiere filiere, Professeur professeur,
                       List<LiberationExceptionnelle> liberationT, LiberationDefinitive liberationD) {
        this.infos_res = infos_res;
        this.salle = salle;
        this.filiere = filiere;
        this.professeur = professeur;
        this.liberationT = liberationT;
        this.liberationD = liberationD;
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


    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
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

    public LiberationDefinitive getLiberationD() {
        return liberationD;
    }

    public void setLiberationD(LiberationDefinitive liberationD) {
        this.liberationD = liberationD;
    }

}
