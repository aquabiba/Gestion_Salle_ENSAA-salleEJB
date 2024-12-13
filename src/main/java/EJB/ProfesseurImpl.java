package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import model.Professeur;

import java.util.List;

@Stateless
public class ProfesseurImpl implements ProfesseurService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;

    @Override
    public Professeur getProfesseurById(int id) {
        return em.find(Professeur.class, id);
    }

    @Override
    public List<Professeur> getAllProfesseur() {
        return em.createQuery("from Professeur", Professeur.class).getResultList();
    }

    @Override
    public void ajouterProfesseur(Professeur professeur) {
        try {
            em.persist(professeur);
            System.out.println("Professeur persisted successfully: " + professeur);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error persisting Professeur: " + e.getMessage());
        }
    }

    @Override
    public void supprimerProfesseur(int id) {
        em.remove(em.find(Professeur.class, id));
    }

    @Override
    public void modifierProfesseur(Professeur professeur) {
        em.merge(professeur);
    }

    @Override
    public Professeur getProfesseurByEmail(String email) {
        String query = "select p from Professeur p where email_Ut =:email";
        return em.createQuery(query, Professeur.class).setParameter("email", email).getSingleResult();
    }

    @Override
    public boolean emailExists(String email) {
        try {
            // Utilisation de getSingleResult() avec une exception pour éviter des erreurs si aucun résultat n'est trouvé
            String mail = (String) em.createQuery("SELECT p.email_Ut FROM Professeur p WHERE p.email_Ut = :email")
                    .setParameter("email", email)
                    .getSingleResult();
            return mail != null && mail.equals(email);  // Vérifie si l'email existe
        } catch (NoResultException e) {
            // Si aucun résultat n'est trouvé, l'email n'existe pas
            return false;
        }
    }



}
