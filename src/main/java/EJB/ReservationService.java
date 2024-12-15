package EJB;

import jakarta.ejb.Local;
import model.Professeur;
import model.Reservation;

import java.util.List;

@Local
public interface ReservationService {
    public void ajouterReservation(Reservation res);
    public void modifierReservation(Reservation res);
    public Reservation getReservationById(int id);
    public List<Reservation> getAllReservations();
    public List<Reservation> getReservationByDate(String date);
    public List<Reservation> getReservationByProf(Professeur prof);
    public List<Object[]> getReservationsWithSalleByFiliere(String filiereName);
    public Reservation getReservationByCreaneauJour(String Creneau, String Jour);
    public Reservation getReservationByCreneauJourFiliere(String creneau, String jour, String filiere);
}
