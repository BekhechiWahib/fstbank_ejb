package fstbank_ejb.services.strategy_access;

import fstbank_ejb.interfaces.IAccesStrategy;

public class AccessProfessionnelStrategy implements IAccesStrategy{
    
    @Override
    public boolean autoriser(OperationType operation, double montant) {
        return true; // règles plus souples
    }
}
