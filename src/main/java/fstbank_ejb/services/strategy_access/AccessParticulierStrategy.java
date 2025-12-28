package fstbank_ejb.services.strategy_access;

import fstbank_ejb.interfaces.IAccesStrategy;

public class AccessParticulierStrategy implements IAccesStrategy{
    @Override
    public boolean autoriser(OperationType operation, double montant) {
        if (operation == OperationType.RETRAIT && montant > 1000) {
            return false;
        }
        return true;
    }
}
