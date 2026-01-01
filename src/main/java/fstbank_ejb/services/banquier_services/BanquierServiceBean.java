package fstbank_ejb.services.banquier_services;

import java.util.ArrayList;


import fstbank_ejb.entity.Client;
import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.util.ClientType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class BanquierServiceBean {   
   @PersistenceContext(unitName = "fstbankPU")
    private EntityManager em;

    public Client creerClient(String nom, String prenom, String adresse, ClientType type) {
            Client client = new Client();
            client.setNom(nom);
            client.setPrenom(prenom);
            client.setAdresse(adresse);
            client.setClientType(type);
            client.setComptes(new ArrayList<>());

            em.persist(client);
            return client;
    }

    public void ajouterCompte(Long clientId, CompteBancaire compte) {

        Client client = em.find(Client.class, clientId);
        compte.setClient(client);
        client.getComptes().add(compte);
     }

   
}
