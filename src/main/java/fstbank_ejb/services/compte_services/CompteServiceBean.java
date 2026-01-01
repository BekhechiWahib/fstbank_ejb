package fstbank_ejb.services.compte_services;

import java.util.Collections;
import java.util.List;

import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.entity.Transaction;
import fstbank_ejb.entity.Users;
import fstbank_ejb.interfaces.ICompteAccessStrategy;
import fstbank_ejb.util.CompteType;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CompteServiceBean {
   
    @EJB
    private CompteFactory compteFactory;
    @EJB
    private CompteAccessStrategyFactory compteAccessStrategyFactory;
  

    @PersistenceContext(unitName = "fstbankPU")
    private EntityManager entityManager;
  

    public CompteBancaire ouvrirCompte(CompteType type, double soldeInitial) {

        CompteBancaire compte = compteFactory.createCompte(type);
        compte.setSolde(soldeInitial);

        entityManager.persist(compte);
        return compte;
    }

    public void retrait(Users user, Long idCompte, double montant) {

        ICompteAccessStrategy strategy = compteAccessStrategyFactory.getStrategy(user);

        if (!strategy.canRetrait()) {
            throw new SecurityException("Accès refusé");
        }
        CompteBancaire compte = entityManager.find(CompteBancaire.class, idCompte);

        // logique métier, traitement et stockage
        if(compte.getSolde() < montant){
            throw new IllegalArgumentException("Solde insuffisant pour cette opération.");
        }
        compte.setSolde(compte.getSolde() - montant);
        entityManager.merge(compte);
    }


     public void virement(Long idSrc, Long idDest, double montant, Users user) {

        ICompteAccessStrategy strategy = compteAccessStrategyFactory.getStrategy(user);

        if (!strategy.canVirement()) {
            throw new SecurityException("Accès refusé");
        }


        CompteBancaire src = entityManager.find(CompteBancaire.class, idSrc);
        CompteBancaire dest = entityManager.find(CompteBancaire.class, idDest);

        // logique métier, traitement et stockage
        if(src.getSolde() < montant){
            throw new IllegalArgumentException("Solde insuffisant pour cette opération.");
        }
        src.setSolde(src.getSolde() - montant);
        dest.setSolde(dest.getSolde() + montant);

        
        entityManager.merge(dest);
        entityManager.merge(src);
    }
   

    public List<Transaction> consulterHistorique(Users user ,Long idCompte) {

        ICompteAccessStrategy strategy = compteAccessStrategyFactory.getStrategy(user);

        if (!strategy.canConsulterHistorique()) {
            throw new RuntimeException("Accès refusé");
        } 
        CompteBancaire compte = entityManager.find(CompteBancaire.class, idCompte);
        if (compte == null) {
            return Collections.emptyList();
        }
        return compte.getTransactions();
        } 


    public void imprimerReleve(Users user, Long idCompte) {

        ICompteAccessStrategy strategy =
            compteAccessStrategyFactory.getStrategy(user);

        if (!strategy.canImprimerReleve()) {
            throw new SecurityException("Accès refusé");
        }

       CompteBancaire compte = entityManager.find(CompteBancaire.class, idCompte);

        if (compte == null) {
            throw new IllegalArgumentException("Compte introuvable");
        }

        // Impression console (suffisant pour le projet)
        System.out.println("===== RELEVÉ DE COMPTE =====");
        System.out.println("Compte ID : " + compte.getId());
        System.out.println("Solde     : " + compte.getSolde());

        for (Transaction t : compte.getTransactions()) {
            System.out.println(
                t.getDate() + " | " +
                t.getType() + " | " +
                t.getMontant()
            );
        }

        System.out.println("============================");
    }




}
