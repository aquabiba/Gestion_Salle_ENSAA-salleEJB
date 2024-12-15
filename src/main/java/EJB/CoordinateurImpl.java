package EJB;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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

    public Coordinateur getCoordinateurByEmail(String email){
        String hql = "select c from Coordinateur c where c.email_Ut=:email";
        return em.createQuery(hql, Coordinateur.class).setParameter("email", email).getSingleResult();
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

    @Override
    public boolean emailExists(String email) {
        try {
            // Utilisation de getSingleResult() avec une exception pour éviter des erreurs si aucun résultat n'est trouvé
            String mail = (String) em.createQuery("SELECT p.email_Ut FROM Coordinateur p WHERE p.email_Ut = :email")
                    .setParameter("email", email)
                    .getSingleResult();
            return mail != null && mail.equals(email);  // Vérifie si l'email existe
        } catch (NoResultException e) {
            // Si aucun résultat n'est trouvé, l'email n'existe pas
            return false;
        }
    }
}
