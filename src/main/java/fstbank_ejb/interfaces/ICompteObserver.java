package fstbank_ejb.interfaces;

import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.util.OperationType;
import jakarta.ejb.Local;

@Local
public interface ICompteObserver {
    public void update(CompteBancaire compte, double lastSoldeChange,OperationType operationType);
}
