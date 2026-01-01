package fstbank_ejb.entity;

import jakarta.persistence.Entity;

@Entity
public class ComptePrive extends CompteBancaire {

    private double  decouvertAutorise;
    private double  tauxDeFraix;
      
    public double getDecouvertAutorise() {
          return this.decouvertAutorise;
      }

    public void setDecouvertAutorise(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }
    public double getTauxDeFraix() {
        return tauxDeFraix;
    }
    public void setTauxDeFraix(double tauxDeFraix) {
        this.tauxDeFraix = tauxDeFraix;
    }
}
