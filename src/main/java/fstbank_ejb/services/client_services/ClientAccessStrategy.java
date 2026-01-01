package fstbank_ejb.services.client_services;

import fstbank_ejb.interfaces.ICompteAccessStrategy;

public class ClientAccessStrategy implements ICompteAccessStrategy {
    public boolean canRetrait() { return true; }
    public boolean canVirement() { return true; }
    public boolean canConsulterSolde() { return true; }
    public boolean canImprimerReleve() { return true; }
    public boolean canConsulterHistorique() { return true; }
}
