package fstbank_ejb.entity;

import jakarta.persistence.Entity;

@Entity
public class ComptePro  extends CompteBancaire {
    private double tauxCommission;
    
    public double getTauxCommission() {
        return tauxCommission;
    }
    public void setTauxCommission(double tauxCommission) {
        this.tauxCommission = tauxCommission;
    }
}
