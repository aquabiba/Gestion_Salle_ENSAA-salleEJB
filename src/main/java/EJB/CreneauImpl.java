package EJB;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Creneau;
import model.Salle;

import java.util.ArrayList;
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
    public List<Salle> getSallesByDisponibilite(String creneau, String jour) {
        String jpql = "SELECT s FROM Salle s " +
                "LEFT JOIN s.creneaux c " + // LEFT JOIN pour inclure les salles sans créneau
                "WHERE (c IS NULL OR " +
                "      (c.desc_creneau = :descCreneau AND " +
                "      NOT EXISTS (" +
                "          SELECT r FROM Reservation r " +
                "          WHERE r.creneau.salle.id_sal = s.id_sal " +
                "          AND r.infos_res.jour_res = :jour " +
                "          AND r.creneau.desc_creneau = :descCreneau)))";



        List<Salle> salles = em.createQuery(jpql, Salle.class)
                .setParameter("descCreneau", creneau)
                .setParameter("jour", jour)
                .getResultList();

        // Si aucune salle n'est trouvée, renvoyer une liste vide, jamais null
        if (salles == null) {
            salles = new ArrayList<>();
        }

        return salles;
    }




/*
Cette fonction renvoie toutes les salles disponibles pour un créneau et un jour donnés.
Les salles retournées sont soit :
  - Non réservées pour ce créneau et jour (aucun créneau correspondant trouvé).
  - Réservées mais marquées comme disponibles (disponibilite_sal = true).
*/
}
