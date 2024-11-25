package EJB;

import jakarta.ejb.Local;
import model.Professeur;

import java.util.List;

@Local
public interface ProfesseurService {
    public Professeur getProfesseurById(int id);
    public List<Professeur> getAllProfesseur();
    public void ajouterProfesseur(Professeur professeur);
    public void supprimerProfesseur(int id);
    public void modifierProfesseur(Professeur professeur);
    public Professeur getProfesseurByEmail(String email);
    public boolean emailExists(String email);

}
