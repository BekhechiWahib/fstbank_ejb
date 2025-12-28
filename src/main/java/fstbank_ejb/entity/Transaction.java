package fstbank_ejb.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id @GeneratedValue
    private Long id;
    private String type;
    private double montant;
    private LocalDate date;

    @ManyToOne
    private CompteBancaire compte;


    public Long getId() { return id; } public void setId(Long id) { this.id = id;}
    public String getType() { return type; } public void setType(String type) { this.type = type; }
    public double getMontant() { return montant; } public void setMontant(double montant) { this.montant = montant; }
    public CompteBancaire getCompte() { return compte; } public void setCompte(CompteBancaire compte) { this.compte = compte; }
    public LocalDate getDate() { return date; } public void setDate(LocalDate date) { this.date = date; }

}
