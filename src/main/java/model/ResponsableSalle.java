package model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class ResponsableSalle extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_resp;

    @OneToMany(mappedBy = "ResponsableSalle")
    private List<Salle> salles;

    public ResponsableSalle(String nom_Ut, String prenom_Ut, String email_Ut,
                            String password_Ut, String telephone_Ut) {
        super(nom_Ut, prenom_Ut, email_Ut, password_Ut, telephone_Ut);

    }
    public ResponsableSalle() {}

    public int getId_resp() {
        return id_resp;
    }

    public void setId_resp(int id_resp) {
        this.id_resp = id_resp;
    }



    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }
}
