package fstbank_ejb.services.transaction_services;

import java.time.LocalDateTime;

import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.entity.Transaction;
import fstbank_ejb.interfaces.ICompteObserver;
import fstbank_ejb.util.OperationType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class TransactionObserver implements ICompteObserver{

    @PersistenceContext
    private EntityManager em;
    @Override
    public void update(CompteBancaire compte, double lastSoldeChange,OperationType operationType) {
         Transaction t = new Transaction();
            t.setCompte(compte);
            t.setMontant(lastSoldeChange);
            t.setOperationType(operationType);
            t.setDate(LocalDateTime.now());

            em.persist(t);
    }
    
}
