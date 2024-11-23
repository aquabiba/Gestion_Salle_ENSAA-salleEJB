package model;
import jakarta.persistence.*;
import java.util.PriorityQueue;
@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sal;
    private String nom_sal;
    private String localisation_sal;
    private String type_sal;
    private Boolean disponibilte_sal;
    private int capacite_sal;
   @OneToMany(mappedBy = "salle")
    private PriorityQueue<Reservation> reservations;
   @ManyToOne
   private ResponsableSalle responsableSalle;



    public Salle(String nom_sal, String localisation_sal,
                 String type_sal, Boolean disponibilte_sal, int capacite_sal) {

        this.nom_sal = nom_sal;
        this.localisation_sal = localisation_sal;
        this.type_sal = type_sal;
        this.disponibilte_sal = disponibilte_sal;
        this.capacite_sal = capacite_sal;
    }

    public Salle() {

    }
    //ajouter un element à la queue
    public void ajouterElement(Reservation res){
        reservations.add(res);
    }
    //afficher le premier element.
    public Reservation retirerElement(){
        return reservations.poll();
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

    public PriorityQueue<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(PriorityQueue<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Boolean getDisponibilte_sal() {
        return disponibilte_sal;
    }

    public void setDisponibilte_sal(Boolean disponibilte_sal) {
        this.disponibilte_sal = disponibilte_sal;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id_sal=" + id_sal +
                ", nom_sal='" + nom_sal + '\'' +
                ", localisation_sal='" + localisation_sal + '\'' +
                ", type_sal='" + type_sal + '\'' +
                ", disponibilte_sal=" + disponibilte_sal +
                ", capacite_sal=" + capacite_sal +
                ", reservations=" + reservations +
                '}';
    }
}
