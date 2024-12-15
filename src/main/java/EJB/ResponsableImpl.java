package EJB;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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

    @Override
    public boolean emailExists(String email) {
        try {
            // Utilisation de getSingleResult() avec une exception pour éviter des erreurs si aucun résultat n'est trouvé
            String mail = (String) em.createQuery("SELECT p.email_Ut FROM ResponsableSalle p WHERE p.email_Ut = :email")
                    .setParameter("email", email)
                    .getSingleResult();
            return mail != null && mail.equals(email);  // Vérifie si l'email existe
        } catch (NoResultException e) {
            // Si aucun résultat n'est trouvé, l'email n'existe pas
            return false;
        }
    }
}
