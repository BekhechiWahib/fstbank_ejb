package fstbank_ejb.services.compte_services;

import fstbank_ejb.entity.CompteBancaire;
import jakarta.ejb.Stateless;

@Stateless
public abstract class CompteFactory {
    // pour la creation des different comptes
    public CompteBancaire createCompte();
}
