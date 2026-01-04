package fstbank_ejb.interfaces;

import fstbank_ejb.entity.Client;
import fstbank_ejb.entity.Users;
import fstbank_ejb.util.ClientType;
import fstbank_ejb.util.UserType;
import jakarta.ejb.Remote;

@Remote
public interface BanquierServiceRemote {
    public Client creerClient(String nom, String prenom, String adresse, ClientType type);
    public void ajouterCompte(Long clientId, Long compteId);
    public Users creerUserPourClient(Long clientId, UserType type);
    public Client getClientById(Long id);
}
