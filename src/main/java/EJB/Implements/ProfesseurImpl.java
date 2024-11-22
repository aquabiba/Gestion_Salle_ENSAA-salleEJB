package EJB.Implements;

import EJB.services.ProfesseurService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
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
        em.persist(professeur);
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
        String query = "from Professeur where email_Ut = :email";
        return em.createQuery(query, Professeur.class).setParameter("email", email).getSingleResult();
    }
}
