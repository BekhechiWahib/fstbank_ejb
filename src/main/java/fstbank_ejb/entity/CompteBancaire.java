package fstbank_ejb.entity;

import java.io.Serializable;
import java.util.List;


import fstbank_ejb.util.CompteType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CompteBancaire  implements Serializable{
    @Id @GeneratedValue
    private Long id;
    private double solde;
    @Enumerated(EnumType.STRING)
    private CompteType compteType;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
    private List<Transaction> transactions; 

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public double getSolde() { return solde; } public void setSolde(double solde) { this.solde = solde; }
    public Client getClient() { return client; } public void setClient(Client client) { this.client = client; }
    public List<Transaction> getTransactions() { return transactions; } public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }

  
   
}
