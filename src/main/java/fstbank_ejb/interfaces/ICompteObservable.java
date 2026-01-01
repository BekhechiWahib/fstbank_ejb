package fstbank_ejb.interfaces;

public interface ICompteObservable {
    
    public boolean attachClient(ICompteObserver obs);
    public boolean dettachClient(ICompteObserver obs);
    public void notify_client();
    
}
