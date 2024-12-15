package model;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sal;
    private String nom_sal;
    private String localisation_sal;
    private String type_sal;
    private int capacite_sal;
   @ManyToOne
   private ResponsableSalle responsableSalle;
    @OneToMany(mappedBy = "salle",fetch = FetchType.EAGER)
    private List<Creneau> creneaux;





    public Salle(String nom_sal, String localisation_sal,
                 String type_sal,int capacite_sal, ResponsableSalle responsableSalle) {

        this.nom_sal = nom_sal;
        this.localisation_sal = localisation_sal;
        this.type_sal = type_sal;
        this.capacite_sal = capacite_sal;
        this.responsableSalle = responsableSalle;

    }

    public Salle() {

    }


    public List<Creneau> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(List<Creneau> creneaux) {
        this.creneaux = creneaux;
    }

    public ResponsableSalle getResponsableSalle() {
        return responsableSalle;
    }

    public void setResponsableSalle(ResponsableSalle responsableSalle) {
        this.responsableSalle = responsableSalle;
    }
    public int getId_sal() {
        return id_sal;
    }

    public void setId_sal(int id_sal) {
        this.id_sal = id_sal;
    }

    public String getNom_sal() {
        return nom_sal;
    }

    public void setNom_sal(String nom_sal) {
        this.nom_sal = nom_sal;
    }

    public String getLocalisation_sal() {
        return localisation_sal;
    }

    public void setLocalisation_sal(String localisation_sal) {
        this.localisation_sal = localisation_sal;
    }

    public String getType_sal() {
        return type_sal;
    }

    public void setType_sal(String type_sal) {
        this.type_sal = type_sal;
    }

    public int getCapacite_sal() {
        return capacite_sal;
    }

    public void setCapacite_sal(int capacite_sal) {
        this.capacite_sal = capacite_sal;
    }


}

