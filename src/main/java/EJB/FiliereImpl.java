package EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Filiere;

import java.util.List;

@Stateless
public class FiliereImpl implements FiliereService {
    @PersistenceContext(unitName = "salleEJB")
    private EntityManager em;

    @Override
    public Filiere getFiliereById(int id) {
        return em.find(Filiere.class, id);
    }

    @Override
    public Filiere getFiliereByName(String filiereName) {
        String hql = "SELECT f FROM Filiere f WHERE f.libelle_fil =:filiereName";
        return em.createQuery(hql, Filiere.class).setParameter("filiereName", filiereName).getSingleResult();
    }

    @Override
    public List<Filiere> getAllFilieres() {
        return em.createQuery("SELECT f FROM Filiere f", Filiere.class).getResultList();
    }

    @Override
    public void ajouterFiliere(Filiere filiere) {
        em.persist(filiere);
    }

    @Override
    public void supprimerFiliere(int id) {
        em.remove(em.find(Filiere.class, id));
    }

    @Override
    public void modifierFiliere(Filiere filiere) {
        em.merge(filiere);
    }
}
