package EJB.Implements;

import EJB.services.SalleService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Salle;

import java.util.List;

@Stateless
public class SalleImpl implements SalleService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;


    @Override
    public void ajouterSalle(Salle salle) {
        em.persist(salle);
    }

    @Override
    public void modifierSalle(Salle salle) {
        em.merge(salle);
    }

    @Override
    public void supprimerSalle(int idSalle) {
        em.remove(em.find(Salle.class, idSalle));
    }

    @Override
    public Salle getSalleById(int idSalle) {
        return em.find(Salle.class, idSalle);
    }

    @Override
    public List<Salle> getAllSalles() {
        return em.createQuery("select s from Salle s", Salle.class).getResultList();
    }
}
