package fstbank_ejb.services.client_services;

import java.util.List;

import fstbank_ejb.entity.Client;
import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.interfaces.ClientServiceRemote;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ClientServiceBean implements ClientServiceRemote {

  @PersistenceContext
    private EntityManager em;

    @Override
    public List<CompteBancaire> getListeComptes(Long clientId) {
        Client client = em.find(Client.class, clientId);
        return client.getComptes(); // OK (managed)
    }
}
