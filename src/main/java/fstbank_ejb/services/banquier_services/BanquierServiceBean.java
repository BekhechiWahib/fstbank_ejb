package fstbank_ejb.services.banquier_services;

import java.util.ArrayList;


import fstbank_ejb.entity.Client;
import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.entity.Users;
import fstbank_ejb.interfaces.BanquierServiceRemote;
import fstbank_ejb.interfaces.IUserService;
import fstbank_ejb.util.ClientType;
import fstbank_ejb.util.UserType;
import jakarta.ejb.EJB;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Remote(BanquierServiceRemote.class)
@Stateless
public class BanquierServiceBean implements BanquierServiceRemote{   
    @PersistenceContext
    private EntityManager em;
    @EJB
    private IUserService userService;


    @Override
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

    @Override
    public Users creerUserPourClient(Long clientId, UserType type) {
        Client client = em.find(Client.class, clientId);

        Users user = new Users();
        user.setUserType(type);
        user.setClient(client);

        return userService.save(user);
    }

    @Override
   public void ajouterCompte(Long clientId, Long compteId) {
        Client client = em.find(Client.class, clientId);
        CompteBancaire compte = em.find(CompteBancaire.class, compteId);

        client.getComptes().add(compte);
        compte.setClient(client);
    }

    @Override
        public Client getClientById(Long id) {
                Client client = em.find(Client.class, id);
                client.getComptes().size(); // forcer chargement
                return client;
        }


   
}
