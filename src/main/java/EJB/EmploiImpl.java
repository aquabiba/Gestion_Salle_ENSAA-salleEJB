package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import model.Emploi;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.util.List;

@Stateless
public class EmploiImpl implements EmploiService {

    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;

    @Override
    public Emploi getEmploiById(int id) {
        return em.find(Emploi.class, id);
    }

    @Override
    public Emploi getEmploiByName(String name) {
        String sql = "SELECT e FROM Emploi e WHERE e.desc_empl = :name";
        List<Emploi> resultList = em.createQuery(sql, Emploi.class)
                .setParameter("name", name)
                .getResultList();

        if (resultList.isEmpty()) {
            return null; // Retourne null si aucun résultat
        }
        return resultList.getFirst(); // Retourne le premier résultat
    }


    @Override
    public List<Emploi> getAllEmplois() {
        TypedQuery<Emploi> query = em.createQuery("SELECT e FROM Emploi e", Emploi.class);
        return query.getResultList();
    }

    @Override
    public void ajouterEmploi(Emploi emploi) {
        em.persist(emploi);
    }

    @Override
    public void supprimerEmploi(int id) {
        Emploi emploi = em.find(Emploi.class, id);
        if (emploi != null) {
            em.remove(emploi);
        }
    }

    @Override
    public void modifierEmploi(Emploi emploi) {
        em.merge(emploi);
    }



}

