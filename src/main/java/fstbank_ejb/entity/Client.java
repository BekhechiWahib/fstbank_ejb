package fstbank_ejb.entity;


import java.util.List;

import fstbank_ejb.util.ClientType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends Users {
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CompteBancaire> comptes;

    @Enumerated(EnumType.STRING)
    private ClientType clientType;
   
   public List<CompteBancaire> getComptes() {
       return comptes;
   }
    public void setComptes(List<CompteBancaire> comptes) {
        this.comptes = comptes;
    }

    public ClientType getClientType() {
        return clientType;
    }
     public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
    
    
}
