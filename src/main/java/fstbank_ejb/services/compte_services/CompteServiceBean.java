package fstbank_ejb.services.compte_services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CompteServiceBean {
     @EJB
    private CompteFactory compteFactory;

    @PersistenceContext
    private EntityManager em;

    public CompteBanquaire ouvrirCompte(CompteType type, double soldeInitial) {

        CompteBanquaire compte = compteFactory.createCompte(type);
        compte.setSolde(soldeInitial);

        em.persist(compte);
        return compte;
    }
}
