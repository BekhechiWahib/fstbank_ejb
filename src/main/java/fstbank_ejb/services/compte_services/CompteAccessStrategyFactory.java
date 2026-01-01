package fstbank_ejb.services.compte_services;

import fstbank_ejb.entity.Users;
import fstbank_ejb.interfaces.ICompteAccessStrategy;
import fstbank_ejb.services.banquier_services.BanquierAccessStrategy;
import fstbank_ejb.services.client_services.ClientAccessStrategy;
import jakarta.ejb.Stateless;

@Stateless
public class CompteAccessStrategyFactory {
    
  public ICompteAccessStrategy getStrategy(Users user) {

        if (user == null) {
            throw new IllegalArgumentException("User null");
        }

        switch (user.getUserType()) {
            case CLIENT:
                return new ClientAccessStrategy();

            case BANQUIER:
                return new BanquierAccessStrategy();

            default:
                throw new IllegalStateException("Type utilisateur inconnu");
        }
    }
}
