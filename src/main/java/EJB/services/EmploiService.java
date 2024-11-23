package EJB.services;

import jakarta.ejb.Local;
import model.Emploi;

import java.util.List;

@Local
public interface EmploiService {
    Emploi getEmploiById(int id);
    List<Emploi> getAllEmplois();
    void ajouterEmploi(Emploi emploi);
    void supprimerEmploi(int id);
    void modifierEmploi(Emploi emploi);
    byte[] generateEmploiPdf(int id); // Returns the PDF as a byte array for download.
}
