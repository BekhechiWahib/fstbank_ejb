package fstbank_ejb.entity;

import java.util.ArrayList;
import java.util.List;

import fstbank_ejb.interfaces.ICompteObservable;
import fstbank_ejb.interfaces.ICompteObserver;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

@Entity
public class ComptePartager extends CompteBancaire implements ICompteObservable{
    
    @ManyToMany
    private List<Client> listClientsPartages = new ArrayList<>();

    @Transient
    private List<ICompteObserver> observers = new ArrayList<>();

    @Transient
    private double lastSoldeChange;


    @Override
    public boolean attachClient(ICompteObserver obs) {
        return observers.add(obs);
    }
    @Override
    public boolean dettachClient(ICompteObserver obs) {
         return observers.remove(obs);
    }
    @Override
    public void notify_client() {
         for (ICompteObserver obs : observers) {
            obs.update(this, lastSoldeChange);
        }
    }

    public void notifierChangementSolde(double lastSolde) {
        this.lastSoldeChange = lastSolde;
        notify_client();
    }
}
