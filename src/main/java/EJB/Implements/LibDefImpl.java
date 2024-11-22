package EJB.Implements;

import EJB.services.LibDefService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.LiberationDefinitive;
import model.Reservation;

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
            int id = liberationDefinitive.getReservation().getId_res();
        String hql = "UPDATE Reservation r SET r.infos_res.status_res = :newStatus WHERE r.id = :reservationId";
        return em.createQuery(hql,Reservation.class).setParameter("newStatus", true).setParameter("reservationId", id).getSingleResult();



    }

    @Override
    public void LiberationAuto(Reservation reservation) {

    }
}
