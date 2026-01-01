package fstbank_ejb.services.client_services;

import java.util.List;

import fstbank_ejb.entity.Client;
import fstbank_ejb.entity.CompteBancaire;
import jakarta.ejb.Stateless;

@Stateless
public class ClientServiceBean {

    public List<CompteBancaire> getListeComptes(Client client) {
        return client.getComptes(); 
    }
}
