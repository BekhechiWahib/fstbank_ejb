package fstbank_ejb.interfaces;

import java.util.List;

import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.entity.Transaction;
import fstbank_ejb.util.CompteType;
import jakarta.ejb.Remote;

@Remote
public interface CompteServiceRemote {
        public CompteBancaire ouvrirCompte(CompteType type, double soldeInitial);
        public List<Transaction> getTransactionsByCompte(Long compteId);
        public void retrait(Long userId, Long idCompte, double montant);
        public void  virement(Long userId, Long idSrc, Long idDest, double montant);
        public List<Transaction>  consulterHistorique(Long userId, Long idCompte);
        public void  imprimerReleve(Long userId, Long idCompte);
}
