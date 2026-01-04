package fstbank_ejb.interfaces;

import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.util.OperationType;
import jakarta.ejb.Local;

@Local
public interface ICompteObservable {
    
    public void attachClient(ICompteObserver obs);
    public void dettachClient(ICompteObserver obs);
    public void notifyObservers(CompteBancaire compte, double montant,OperationType operationType);
    
}
