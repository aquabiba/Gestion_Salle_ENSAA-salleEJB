package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.LiberationExceptionnelle;
import model.Reservation;
import model.Salle;


@Stateless
public class LibExefImpl implements LibExeService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;
    @Override
    public Reservation ajouterLibExe(LiberationExceptionnelle liberationExceptionnelle) {
        em.persist(liberationExceptionnelle);
        int id_res=liberationExceptionnelle.getReservation().getId_res();
        String hql = "UPDATE Reservation r SET r.infos_res.status_res = :newStatus WHERE r.id = :reservationId";
        return em.createQuery(hql,Reservation.class).setParameter("newStatus", false).setParameter("reservationId", id_res).getSingleResult();

    }

    @Override
    public void ModifierLibExe(LiberationExceptionnelle libEX) {
        em.merge(libEX);
    }

    @Override
    public LiberationExceptionnelle getLibExeById(int id) {
        return em.find(LiberationExceptionnelle.class, id);
    }

    @Override
    public Reservation annulerLibExe(int id) {
        String query ="SELECT l.reservation from LiberationExceptionnelle l WHERE l.id_lib_exe = :id ";
        Reservation res = em.createQuery(query,Reservation.class).setParameter("id",id).getSingleResult();

        int idReservation=res.getId_res();

        String q = "UPDATE Reservation  r SET r.infos_res.status_res = true WHERE r.id_res = :idReservation";
        return em.createQuery(q, Reservation.class).setParameter("idReservation", idReservation).getSingleResult();
    }
}
