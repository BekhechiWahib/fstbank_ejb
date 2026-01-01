package fstbank_ejb.interfaces;

public interface ICompteAccessStrategy {
    public boolean canVirement();
    public boolean canRetrait();
    public boolean canConsulterSolde();
    public boolean canImprimerReleve();
    public boolean canConsulterHistorique();
}
