package EJB;

import jakarta.ejb.Local;
import model.Reservation;
import model.Salle;

import java.util.List;

@Local
public interface SalleService {

    public void ajouterSalle(Salle salle);
    public void modifierSalle(Salle salle);
    public void supprimerSalle(int idSalle);
    public Salle getSalleById(int idSalle);
    public Salle getSalleByName(String nom);
    public List<Salle> getAllSalles();
    public Reservation getSalleByJourCrenFiliere(String jour, String cren , String filiere);
}
