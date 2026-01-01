package fstbank_ejb.entity;


import java.util.List;

import fstbank_ejb.util.ClientType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends Users {
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CompteBanquaire> comptes;

    @Enumerated(EnumType.STRING)
    private ClientType type;
   
   public List<CompteBanquaire> getComptes() {
       return comptes;
   }
    public void setComptes(List<CompteBanquaire> comptes) {
        this.comptes = comptes;
    }
}
