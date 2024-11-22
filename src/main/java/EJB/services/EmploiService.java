package EJB.services;

import jakarta.ejb.Local;
import model.Emploi;

import java.util.List;

@Local
public interface EmploiService {
    public Emploi getEmploiById(int id);
    public List<Emploi> getAllEmplois();
    public void ajouterEmploi(Emploi emploi);
    public void supprimerEmploi(int id);
    public void modifierEmploi(Emploi emploi);
}
