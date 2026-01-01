package fstbank_ejb.services.banquier_services;

import fstbank_ejb.interfaces.ICompteAccessStrategy;

public class BanquierAccessStrategy implements ICompteAccessStrategy {
    public boolean canRetrait() { return false; }
    public boolean canVirement() { return false; }
    public boolean canConsulterSolde() { return true; }
    public boolean canImprimerReleve() { return true; }
    public boolean canConsulterHistorique() { return true; }
}
