package EJB.Implements;

import EJB.services.EmploiService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import model.Emploi;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    @Override
    public byte[] generateEmploiPdf(int id) {
        Emploi emploi = em.find(Emploi.class, id);
        if (emploi == null) {
            throw new IllegalArgumentException("Emploi not found with ID: " + id);
        }

        // Generate PDF using PDFBox
        try (PDDocument document = new PDDocument();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            // Add a page
            PDPage page = new PDPage();
            document.addPage(page);

            // Write content
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.beginText();
                contentStream.setLeading(14.5f);
                contentStream.newLineAtOffset(50, 700);

                contentStream.showText("Emploi Details:");
                contentStream.newLine();
                contentStream.showText("ID: " + emploi.getId_empl());
                contentStream.newLine();
                contentStream.showText("coordinateur: " + emploi.getCoord());
                contentStream.newLine();
                contentStream.endText();

            }

            // Save to ByteArrayOutputStream
            document.save(out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}

