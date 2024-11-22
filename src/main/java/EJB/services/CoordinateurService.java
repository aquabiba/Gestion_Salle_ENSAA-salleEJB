package EJB.services;

import jakarta.ejb.Local;
import model.Coordinateur;

import java.util.List;

@Local
public interface CoordinateurService {
      public Coordinateur getCoordinateurById(int id);
      public Coordinateur getCoordinateurByName(String name);
      public List<Coordinateur> findAllCoordinateur();
      public void ajouterCoordinateur(Coordinateur coordinateur);
      public void modifierCoordinateur(Coordinateur coordinateur);
      public void supprimerCoordinateur(int id);
}
