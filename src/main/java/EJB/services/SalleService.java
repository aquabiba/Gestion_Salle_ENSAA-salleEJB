package EJB.services;

import jakarta.ejb.Local;
import model.Salle;

import java.util.List;

@Local
public interface SalleService {

    public void ajouterSalle(Salle salle);
    public void modifierSalle(Salle salle);
    public void supprimerSalle(int idSalle);
    public Salle getSalleById(int idSalle);
    public List<Salle> getAllSalles();
}
