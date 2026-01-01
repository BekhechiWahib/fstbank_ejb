package fstbank_ejb.interfaces;

import java.util.List;

public interface ICompteObservable {
    // List of clients subscribed to a shared account
    public List<ICompteObserver> comptePartagerSubscriber;
    // the latest change of the sold in the shared account
    public double lastSoldeChange;

    public boolean attachClient(ICompteObserver obs);
    public boolean dettachClient(ICompteObserver obs);
    public void notify();
    
}
