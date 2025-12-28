package fstbank_ejb.services.compte_services;

import fstbank_ejb.entity.CompteBancaire;

public class CompteParticulierConcret extends CompteFactory{

    public CompteBancaire createCompte() {
        return CompteBancaire;
    }
}
