package fstbank_ejb.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import fstbank_ejb.util.OperationType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction implements Serializable{
    @Id @GeneratedValue
    private Long id;
   
    @Enumerated(EnumType.STRING)
    private OperationType operationType;
    
    private double montant;
    private LocalDateTime date;

    @ManyToOne
    private CompteBancaire compte;


    public Long getId() { return id; } public void setId(Long id) { this.id = id;}
    public OperationType getOperationType() { return operationType; } public void setOperationType(OperationType type) { this.operationType = type; }
    public double getMontant() { return montant; } public void setMontant(double montant) { this.montant = montant; }
    public CompteBancaire getCompte() { return compte; } public void setCompte(CompteBancaire compte) { this.compte = compte; }
    public LocalDateTime getDate() { return date; } public void setDate(LocalDateTime date) { this.date = date; }

}
