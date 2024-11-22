package EJB.Implements;

import EJB.services.MatiereService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Matiere;

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
        return em.createQuery("SELECT m FROM Matiere m", Matiere.class).getResultList();
    }

    @Override
    public void ajouterMatiere(Matiere matiere) {
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
