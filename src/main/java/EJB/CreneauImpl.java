package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Creneau;
import model.Salle;

import java.util.List;
@Stateless
public class CreneauImpl implements CreneauService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;

    @Override
    public void addCreneau(Creneau creneau) {
        em.persist(creneau);
    }

    @Override
    public void updateCreneau(Creneau creneau) {
        em.merge(creneau);

    }

    @Override
    public void deleteCreneau(Creneau creneau) {
        em.remove(creneau);
    }

    @Override
    public Creneau getCreneauById(int id) {
        String hql = "select c from Creneau c where c.id = :id";
        return em.createQuery(hql, Creneau.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Creneau> getCreneaux() {
        return em.createQuery("select c from Creneau c", Creneau.class).getResultList();
    }

    @Override
    public List<Salle> getSallesByDisponibilite(String creneau) {
        String hql = "SELECT DISTINCT s\n" +
                "FROM Salle s\n" +
                "LEFT JOIN s.creneaux c WITH c.desc_creneau = :cren\n" +
                "WHERE c IS NULL OR c.disponibilite_sal = true\n";
        return em.createQuery(hql, Salle.class).setParameter("cren",creneau).getResultList();
    }  /*La fonction renvoie toutes les salles qui, pour le créneau spécifié par creneau,
    sont soit non réservées (aucun créneau correspondant trouvé) soit réservées mais marquées
    comme disponibles (disponibilite_sal = true). C’est un moyen de lister les salles
    disponibles à un créneau donné, qu’elles soient sans réservation ou déjà marquées disponibles.*/
}
