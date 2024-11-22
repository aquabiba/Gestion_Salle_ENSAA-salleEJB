package model;

import jakarta.persistence.*;
@MappedSuperclass
public abstract class Utilisateur {

    //private Long id_Ut;
    private String nom_Ut;
    private String prenom_Ut;
    private String email_Ut;
    private String password_Ut;
    private String telephone_Ut;

    public Utilisateur(String nom_Ut, String prenom_Ut, String email_Ut, String password_Ut, String telephone_Ut) {
        this.nom_Ut = nom_Ut;
        this.prenom_Ut = prenom_Ut;
        this.email_Ut = email_Ut;
        this.password_Ut = password_Ut;
        this.telephone_Ut = telephone_Ut;
    }

    public Utilisateur() {

    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom_Ut='" + nom_Ut + '\'' +
                ", prenom_Ut='" + prenom_Ut + '\'' +
                ", email_Ut='" + email_Ut + '\'' +
                ", password_Ut='" + password_Ut + '\'' +
                ", telephone_Ut='" + telephone_Ut + '\'' +
                '}';
    }

    public String getTelephone_Ut() {
        return telephone_Ut;
    }

    public void setTelephone_Ut(String telephone_Ut) {
        this.telephone_Ut = telephone_Ut;
    }

    public String getPassword_Ut() {
        return password_Ut;
    }

    public void setPassword_Ut(String password_Ut) {
        this.password_Ut = password_Ut;
    }

    public String getEmail_Ut() {
        return email_Ut;
    }

    public void setEmail_Ut(String email_Ut) {
        this.email_Ut = email_Ut;
    }

    public String getPrenom_Ut() {
        return prenom_Ut;
    }

    public void setPrenom_Ut(String prenom_Ut) {
        this.prenom_Ut = prenom_Ut;
    }

    public String getNom_Ut() {
        return nom_Ut;
    }

    public void setNom_Ut(String nom_Ut) {
        this.nom_Ut = nom_Ut;
    }
}