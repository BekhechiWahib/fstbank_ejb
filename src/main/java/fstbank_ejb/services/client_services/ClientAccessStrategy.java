package fstbank_ejb.services.client_services;

import fstbank_ejb.interfaces.ICompteAccessStrategy;

public class ClientAccessStrategy implements ICompteAccessStrategy {
    @Override
    public boolean canRetrait() { return true; }
    @Override
    public boolean canVirement() { return true; }
    @Override
    public boolean canConsulterSolde() { return true; }
    @Override
    public boolean canImprimerReleve() { return true; }
   @Override
    public boolean canConsulterHistorique() { return true; }
   
}
