package EJB;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Coordinateur;
import model.Matiere;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class MatiereImpl implements MatiereService {

    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;

    @Override
    public Matiere getMatiereById(int id) {
        return em.find(Matiere.class, id);
    }

    @Override
    public Matiere getMatiereByName(String libelle_mat) {
        String query = "SELECT m FROM Matiere m WHERE m.libelle_mat = :matiereName";
        return em.createQuery(query, Matiere.class).setParameter("matiereName", libelle_mat).getSingleResult();
    }

    @Override
    public List<Matiere> getAllMatieres() {
        List<Matiere> matieres =  em.createQuery("SELECT m FROM Matiere m", Matiere.class).getResultList();
        if (matieres != null) {
            return matieres;
        }else return null;
    }

    @Override
    public void ajouterMatiere(Matiere matiere) {
        // Reattach the Coordinateur entity to the persistence context
        Coordinateur managedCoord = em.merge(matiere.getCoordinateur());
        matiere.setCoordinateur(managedCoord); // Set the managed entity

        // Persist the Matiere
        em.persist(matiere);
    }

    @Override
    public void supprimerMatiere(int id) {
        em.remove(em.find(Matiere.class, id));
    }

    @Override
    public void modifierMatiere(Matiere matiere) {
        em.merge(matiere);
    }
}
