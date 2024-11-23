package EJB;

import jakarta.ejb.Local;
import model.LiberationExceptionnelle;
import model.Reservation;

@Local
public interface LibExeService {
    public Reservation ajouterLibExe(LiberationExceptionnelle libEX);
    public void ModifierLibExe(LiberationExceptionnelle libEX);
    public LiberationExceptionnelle getLibExeById(int id);
    public Reservation annulerLibExe(int id);


}
