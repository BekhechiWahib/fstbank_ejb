package fstbank_ejb.services.banquier_services;

import fstbank_ejb.interfaces.ICompteAccessStrategy;

public class BanquierAccessStrategy implements ICompteAccessStrategy {
    @Override
    public boolean canRetrait() { return false; }
    @Override
    public boolean canVirement() { return false; }
    @Override
    public boolean canConsulterSolde() { return true; }
    @Override
    public boolean canImprimerReleve() { return true; }
   @Override
    public boolean canConsulterHistorique() { return true; }
}
