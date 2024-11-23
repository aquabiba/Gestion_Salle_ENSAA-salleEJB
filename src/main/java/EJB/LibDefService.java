package EJB;
import jakarta.ejb.Local;
import model.LiberationDefinitive;
import model.Reservation;

import java.util.List;

@Local
public interface LibDefService {

    public LiberationDefinitive getLiberationDefinitiveById(int id);
    public List<LiberationDefinitive> getAllLiberationDefinitives();
    public Reservation ajouterLiberationDefinitive(LiberationDefinitive liberationDefinitive);
    public void LiberationAuto();
}
