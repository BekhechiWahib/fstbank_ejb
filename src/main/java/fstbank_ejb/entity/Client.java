package fstbank_ejb.entity;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client extends Users {
    @Id
    @GeneratedValue
    private Long id;
    private ArrayList<CompteBanquaire> comptes; 
    @Enumerated(EnumType.STRING)
    private ClientType type;
    @Transient
    private IAccessStrategy accessStrategy;


    public ClientType getType() {
        return type;
    }
    public void setType(ClientType type) {
        this.type = type;
    }

    public IAccessStrategy getAccessStrategy() {
        return accessStrategy;
    }
    public void setAccessStrategy(IAccessStrategy accessStrategy) {
        this.accessStrategy = accessStrategy;
    }

    public ArrayList<CompteBanquaire> getComptes() {
        return comptes;
    }
    public void setComptes(ArrayList<CompteBanquaire> comptes) {
        this.comptes = comptes;
    }
}
