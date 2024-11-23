package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.ResponsableSalle;

import java.util.List;

@Stateless
public class ResponsableImpl implements ResponsableService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;

    @Override
    public void ajouterResponsable(ResponsableSalle responsable) {
        em.persist(responsable);
    }

    @Override
    public void supprimerResponsable(int id) {
        em.remove(em.find(ResponsableSalle.class, id));
    }

    @Override
    public List<ResponsableSalle> getAllResponsables() {
        return em.createQuery("select r from ResponsableSalle r", ResponsableSalle.class).getResultList();
    }

    @Override
    public ResponsableSalle getResponsableById(int id) {
        return em.find(ResponsableSalle.class,id);
    }

    @Override
    public ResponsableSalle getResponsableByEmail(String email) {
        String query = "select r from ResponsableSalle r where r.email_Ut = :email";
        return em.createQuery(query, ResponsableSalle.class).setParameter("email", email).getSingleResult() ;
    }

    @Override
    public ResponsableSalle getResponsableByTel(String tel) {
        String query="select r from ResponsableSalle r where r.telephone_Ut = :tel_ut";
        return em.createQuery(query,ResponsableSalle.class).setParameter("tel_ut",tel).getSingleResult() ;
    }

    @Override
    public void modifierResponsable(ResponsableSalle responsable) {
        em.merge(responsable);
    }
}
