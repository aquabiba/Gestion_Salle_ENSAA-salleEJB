package EJB.services;

import jakarta.ejb.Local;
import model.Matiere;

import java.util.List;

@Local
public interface MatiereService {
    public Matiere getMatiereById(int id);
    public Matiere getMatiereByName(String matiereName);
    public List<Matiere> getAllMatieres();
    public void ajouterMatiere(Matiere matiere);
    public void supprimerMatiere(int id);
    public void modifierMatiere(Matiere matiere);
}
