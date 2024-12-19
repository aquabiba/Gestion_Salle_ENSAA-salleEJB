package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import model.Reservation;
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
    public Salle getSalleByName(String nom) {
        String hql = "select s from Salle s where s.nom_sal = :nom";
        return em.createQuery(hql, Salle.class).setParameter("nom", nom).getSingleResult();
    }

    @Override
    public List<Salle> getAllSalles() {
        return em.createQuery("select s from Salle s", Salle.class).getResultList();
    }


    @Override
    public Reservation getSalleByJourCrenFiliere(String jour, String cren, String filiere) {
        try {
            // Query to fetch the reservation based on day, slot, and study program
            String qlString = "SELECT res FROM Reservation res " +
                    "JOIN res.creneau.salle s " +
                    "JOIN res.creneau cren " +
                    "WHERE res.infos_res.jour_res = :jour AND cren.desc_creneau = :cren AND res.filiere.libelle_fil = :filiere";

            // Create query
            TypedQuery<Reservation> query = em.createQuery(qlString, Reservation.class);
            query.setParameter("jour", jour);
            query.setParameter("cren", cren);
            query.setParameter("filiere", filiere);

            // Get single result
            return query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No reservation found for the specified day, creneau, and filiere");
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
