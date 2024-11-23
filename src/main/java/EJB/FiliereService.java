package EJB;

import jakarta.ejb.Local;
import model.Filiere;

import java.util.List;

@Local
public interface FiliereService {
    public Filiere getFiliereById(int id);
    public Filiere getFiliereByName(String filiereName);
    public List<Filiere> getAllFilieres();
    public void ajouterFiliere(Filiere filiere);
    public void supprimerFiliere(int id);
    public void modifierFiliere(Filiere filiere);

}
