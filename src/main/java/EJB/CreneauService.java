package EJB;

import jakarta.ejb.Local;
import model.Creneau;
import model.Salle;

import java.util.List;
@Local
public interface CreneauService {

    public void addCreneau(Creneau creneau);
    public void updateCreneau(Creneau creneau);
    public void deleteCreneau(Creneau creneau);
    public Creneau getCreneauById(int id);
    public List<Creneau> getCreneaux();
    public List<Salle> getSallesByDisponibilite(String creneau, String jour);
}
