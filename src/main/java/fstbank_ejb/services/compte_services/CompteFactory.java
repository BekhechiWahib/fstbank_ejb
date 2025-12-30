package fstbank_ejb.services.compte_services;

import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.entity.CompteParticulier;
import fstbank_ejb.entity.ComptePro;
import fstbank_ejb.util.CompteType;
import jakarta.ejb.Stateless;

@Stateless
public class CompteFactory {
    
       public CompteBanquaire createCompte(CompteType type) {

        switch (type) {
            case PARTICULIER:
                return new CompteParticulier();

            case PRO:
                return new ComptePro();

            case PRIVE:
                return new ComptePrive();

            default:
                throw new IllegalArgumentException("Type de compte inconnu");
        }
    }
}
