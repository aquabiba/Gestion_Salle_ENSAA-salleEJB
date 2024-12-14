package model;

import jakarta.persistence.*;

@Entity
public class Creneau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_creneau;
    private String desc_creneau;
    private boolean disponibilite_sal;

    @ManyToOne
    private Salle salle;


    public Creneau(String desc_creneau, boolean disponibilite_sal, Salle salle) {
        this.desc_creneau = desc_creneau;
        this.disponibilite_sal = disponibilite_sal;
        this.salle = salle;
    }

    public Creneau() {
    }

    public int getId_creneau() {
        return id_creneau;
    }

    public void setId_creneau(int id_creneau) {
        this.id_creneau = id_creneau;
    }

    public String getDesc_creneau() {
        return desc_creneau;
    }

    public void setDesc_creneau(String desc_creneau) {
        this.desc_creneau = desc_creneau;
    }

    public boolean isDisponibilite_sal() {
        return disponibilite_sal;
    }

    public void setDisponibilite_sal(boolean disponibilite_sal) {
        this.disponibilite_sal = disponibilite_sal;
    }



    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Creneau{" +
                "id_creneau=" + id_creneau +
                ", desc_creneau='" + desc_creneau + '\'' +
                ", disponibilite_sal=" + disponibilite_sal +
                ", salles=" + salle +
                '}';
    }
}
