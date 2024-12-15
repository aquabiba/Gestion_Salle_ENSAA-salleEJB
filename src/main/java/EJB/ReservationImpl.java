package EJB;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Professeur;
import model.Reservation;
import org.hibernate.Hibernate;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ReservationImpl implements ReservationService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;


    @Override
    public void ajouterReservation(Reservation res) {
        em.persist(res);
//        int id = res.getSalle().getId_sal();
//        String query = "UPDATE Salle s SET s.disponibilte_sal=false WHERE s.id_sal=:id  ";
//        em.createQuery(query).setParameter("id", id).executeUpdate();
    }

    //a ne pas manipuler cette fonction
    @Override
    public void modifierReservation(Reservation res) {
        em.merge(res);
    }

    @Override
    public Reservation getReservationById(int id) {
        return em.find(Reservation.class, id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> res = em.createQuery("select r from Reservation r", Reservation.class).getResultList();
        if (!res.isEmpty()){
            return res;
        }else return null;
    }

    @Override
    public List<Reservation> getReservationByDate(String date) {
        String query = "select r from Reservation r where r.infos_res.dateDebut = :date";
        List<Reservation> reservations =  em.createQuery(query, Reservation.class).setParameter("date", date).getResultList();
        if (!reservations.isEmpty()) {
            return reservations;
        }else return null;
    }

    @Override
    public List<Reservation> getReservationByProf(Professeur prof) {
        String query = "select r from Reservation r where r.professeur = :prof";
        return em.createQuery(query, Reservation.class).setParameter("prof", prof).getResultList();
    }
// c est ici la fonction qui va nous permetttre de recuperer les donnees de l'emploi du temps genere automatiquement
    @Override
    public List<Object[]> getReservationsWithSalleByFiliere(String filiereName) {
        String jpql = "SELECT r.creneau, p.matiere, p, c.salle, r.infos_res " +
                "FROM Reservation r " +
                "JOIN r.creneau c " +
                "JOIN c.salle s " +
                "JOIN r.professeur p " +
                "WHERE r.filiere.id = :filiereName";

        return em.createQuery(jpql, Object[].class)
                .setParameter("filiereName", filiereName)
                .getResultList();
    }
    @Override
    public Reservation getReservationByCreaneauJour(String Creneau, String Jour) {
        try {
            String sql = "SELECT r FROM Reservation r WHERE r.creneau.desc_creneau = :Creneau AND r.infos_res.jour_res = :Jour";
            List<Reservation> results = em.createQuery(sql, Reservation.class)
                    .setParameter("Creneau", Creneau)
                    .setParameter("Jour", Jour)
                    .getResultList();
            if (results.isEmpty()) {
                System.out.println("Aucune réservation trouvée pour le créneau et jour spécifiés.");
                return null;
            }
            Reservation reservation = results.get(0); // Sélectionne le premier résultat
            Hibernate.initialize(reservation.getCreneau());
            Hibernate.initialize(reservation.getInfos_res());
            return reservation;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // En cas d'autres erreurs
        }
    }


    @Override
    public Reservation getReservationByCreneauJourFiliere(String creneau, String jour, String filiere) {
        try {
            String sql = "SELECT r FROM Reservation r " +
                    "WHERE r.creneau.desc_creneau = :creneau " +
                    "AND r.infos_res.jour_res = :jour " +
                    "AND r.filiere.libelle_fil = :filiere"; // Condition pour la filière

            List<Reservation> results = em.createQuery(sql, Reservation.class)
                    .setParameter("creneau", creneau)
                    .setParameter("jour", jour)
                    .setParameter("filiere", filiere)
                    .getResultList();

            if (results.isEmpty()) {
                System.out.println("Aucune réservation trouvée pour le créneau, jour et filière spécifiés.");
                return null;
            }

            Reservation reservation = results.get(0); // Sélectionne le premier résultat
            Hibernate.initialize(reservation.getCreneau());
            Hibernate.initialize(reservation.getInfos_res());
            Hibernate.initialize(reservation.getFiliere()); // Initialise l'objet Filiere si nécessaire
            return reservation;

        } catch (Exception e) {
            e.printStackTrace();
            return null; // En cas d'autres erreurs
        }
    }


}


