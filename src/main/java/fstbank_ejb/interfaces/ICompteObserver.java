package fstbank_ejb.interfaces;

import fstbank_ejb.entity.CompteBancaire;

public interface ICompteObserver {
    public void update(CompteBancaire compte, double lastSoldeChange);
}
