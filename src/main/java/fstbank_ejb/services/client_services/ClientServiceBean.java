package fstbank_ejb.services.client_services;

import fstbank_ejb.services.strategy_access.AccessStrategyFactory;
import jakarta.ejb.Stateless;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Stateless
public class ClientServiceBean {


    public boolean verifierAcces(Client client) {
      IAccessStrategy strategy = AccessStrategyFactory.getStrategy(client);
        return strategy.autoriser(client);
    }
}
