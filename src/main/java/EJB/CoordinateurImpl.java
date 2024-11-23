package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Coordinateur;

import java.util.List;

@Stateless
public class CoordinateurImpl implements CoordinateurService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;

    @Override
    public Coordinateur getCoordinateurById(int id) {
        return em.find(Coordinateur.class, id);
    }

    @Override
    public Coordinateur getCoordinateurByName(String name) {
        String hql = "select c from Coordinateur c where c.nom_Ut=:name";
        return em.createQuery(hql, Coordinateur.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Coordinateur> findAllCoordinateur() {
        return em.createQuery("Select c from Coordinateur c", Coordinateur.class).getResultList();
    }

    @Override
    public void ajouterCoordinateur(Coordinateur coordinateur) {
        em.persist(coordinateur);
    }

    @Override
    public void modifierCoordinateur(Coordinateur coordinateur) {
        em.merge(coordinateur);
    }

    @Override
    public void supprimerCoordinateur(int id) {
        em.remove(em.find(Coordinateur.class, id));
    }
}
