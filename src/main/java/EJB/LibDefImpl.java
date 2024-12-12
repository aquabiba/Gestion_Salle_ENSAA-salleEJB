package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.LiberationDefinitive;
import model.Reservation;
import model.Salle;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Stateless
public class LibDefImpl implements LibDefService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;

    @Override
    public LiberationDefinitive getLiberationDefinitiveById(int id) {
        return em.find(LiberationDefinitive.class, id);
    }

    @Override
    public List<LiberationDefinitive> getAllLiberationDefinitives() {
        return em.createQuery("from LiberationDefinitive", LiberationDefinitive.class).getResultList();
    }

    @Override
    public Reservation ajouterLiberationDefinitive(LiberationDefinitive liberationDefinitive) {

            em.persist(liberationDefinitive);
//        int id2 = liberationDefinitive.getReservation().getSalle().getId_sal();
//        String hql2 = "Update Salle s SET s.disponibilte_sal = :newStatus WHERE s.id_sal= :salleId";
//        em.createQuery(hql2, Salle.class).setParameter("newStatus", true).setParameter("salleId", id2);
        int id = liberationDefinitive.getReservation().getId_res();
        String hql = "UPDATE Reservation r SET r.infos_res.status_res = :newStatus WHERE r.id = :reservationId";
        return em.createQuery(hql,Reservation.class).setParameter("newStatus", false).setParameter("reservationId", id).getSingleResult();

    }

    @Override
    public void LiberationAuto() {
        LocalDate currentdate = LocalDate.now();

        String sql = "SELECT r FROM Reservation r WHERE r.infos_res.dateFin < :date";
        List<Reservation> reservationExpires =em.createQuery(sql, Reservation.class).setParameter("date",currentdate).getResultList();

        for(Reservation reservationExpire : reservationExpires){
            int id = reservationExpire.getId_res();

            String hql = "UPDATE Reservation r SET r.infos_res.status_res = :newStatus WHERE r.id = :reservationId";

            em.createQuery(hql,Reservation.class).setParameter("newStatus", false).setParameter("reservationId", id);

            LiberationDefinitive libDef = new LiberationDefinitive(LocalDate.now(),reservationExpire,reservationExpire.getProfesseur());
            em.persist(libDef);
        }
    }
}
