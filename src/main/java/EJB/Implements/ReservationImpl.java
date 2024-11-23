package EJB.Implements;

import EJB.services.ReservationService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Professeur;
import model.Reservation;

import java.util.List;

@Stateless
public class ReservationImpl implements ReservationService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;


    @Override
    public void ajouterReservation(Reservation res) {
        em.persist(res);
        int id = res.getSalle().getId_sal();
        String query = "UPDATE Salle s SET s.disponibilte_sal=false WHERE s.id_sal=:id  ";
        em.createQuery(query).setParameter("id", id).executeUpdate();
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
        return em.createQuery("select r from Reservation r", Reservation.class).getResultList();
    }

    @Override
    public List<Reservation> getReservationByDate(String date) {
        String query = "select r from Reservation r where r.infos_res.dateDebut = :date";
        return em.createQuery(query, Reservation.class).setParameter("date", date).getResultList();
    }

    @Override
    public List<Reservation> getReservationByProf(Professeur prof) {
        String query = "select r from Reservation r where r.professeur = :prof";
        return em.createQuery(query, Reservation.class).setParameter("prof", prof).getResultList();
    }
}
