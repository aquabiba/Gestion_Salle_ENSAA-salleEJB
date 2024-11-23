package EJB;

import jakarta.ejb.Local;
import model.ResponsableSalle;

import java.util.List;

@Local
public interface ResponsableService {
    public void ajouterResponsable(ResponsableSalle responsable);
    public void supprimerResponsable(int id);
    public List<ResponsableSalle> getAllResponsables();
    public ResponsableSalle getResponsableById(int id);
    public ResponsableSalle getResponsableByEmail(String email);
    public ResponsableSalle getResponsableByTel(String tel);
    public void modifierResponsable(ResponsableSalle responsable);
}
