package model;

import jakarta.persistence.*;

@Entity
public class Coordinateur extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_coord;

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

    public int getId_coord() {
        return id_coord;
    }

    public void setId_coord(int id_coord) {
        this.id_coord = id_coord;
    }


}
