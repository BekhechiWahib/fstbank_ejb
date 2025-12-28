package fstbank_ejb.entity;

import java.util.ArrayList;

import fstbank_ejb.services.strategy_access.AccessStrategyFactory;
import jakarta.ejb.Stateless;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CompteBancaire {
    @Id @GeneratedValue
    private Long id;
    private double solde;
    private ArrayList<Transaction> transactions; 

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public double getSolde() { return solde; } public void setSolde(double solde) { this.solde = solde; }
    public ArrayList<Transaction> getTransactions() { return transactions; } public void setTransactions(ArrayList<Transaction> transactions) { this.transactions = transactions; }

  
    
    public String consulterSolde(String numeroCompte) {
        return "Solde pour " + numeroCompte + " : 1000€";
    }

    public boolean virement(String source, String cible, double montant) {
        // logique simple
        return true;
    }
    
    public void retrait(Client client, double montant) {

        IAccessStrategy strategy = AccessStrategyFactory.getStrategy(client);

        if (!strategy.autoriser(OperationType.RETRAIT, montant)) {
            throw new RuntimeException("Accès refusé");
        }

        // suite du traitement
    }
}
