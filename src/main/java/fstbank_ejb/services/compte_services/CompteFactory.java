package fstbank_ejb.services.compte_services;

import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.entity.ComptePartager;
import fstbank_ejb.entity.ComptePrive;
import fstbank_ejb.entity.ComptePro;
import fstbank_ejb.util.CompteType;
import jakarta.ejb.Stateless;

@Stateless
public class CompteFactory {
    
       public CompteBancaire createCompte(CompteType type) {

        switch (type) {
            case PARTAGER:
                return new ComptePartager();

            case PRO:
                return new ComptePro();

            case PRIVE:
                return new ComptePrive();

            default:
                throw new IllegalArgumentException("Type de compte inconnu");
        }
    }
}
