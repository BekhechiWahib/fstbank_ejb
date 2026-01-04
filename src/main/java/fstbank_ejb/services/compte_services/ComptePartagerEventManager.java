package fstbank_ejb.services.compte_services;

import java.util.ArrayList;
import java.util.List;

import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.interfaces.ICompteObservable;
import fstbank_ejb.interfaces.ICompteObserver;
import fstbank_ejb.util.OperationType;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;


@Stateless
@Local(ICompteObservable.class)
public class ComptePartagerEventManager implements ICompteObservable{
     private List<ICompteObserver> observers = new ArrayList<>();

    @Override
    public void attachClient(ICompteObserver obs) {
        observers.add(obs);
    }

    @Override
    public void dettachClient(ICompteObserver obs) {
       observers.remove(obs);
    }

     @Override
     public void notifyObservers(CompteBancaire compte, double montant,OperationType operationType) {
        for (ICompteObserver obs : observers) {
            obs.update(compte, montant,operationType);
        }
    }
    
}
