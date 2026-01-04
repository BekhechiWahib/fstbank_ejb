package fstbank_ejb.services.compte_services;

import java.util.Collections;
import java.util.List;

import fstbank_ejb.entity.CompteBancaire;
import fstbank_ejb.entity.Transaction;
import fstbank_ejb.entity.Users;
import fstbank_ejb.interfaces.CompteServiceRemote;
import fstbank_ejb.interfaces.ICompteAccessStrategy;
import fstbank_ejb.interfaces.ICompteObservable;
import fstbank_ejb.interfaces.ICompteObserver;
import fstbank_ejb.interfaces.IUserService;
import fstbank_ejb.util.CompteType;
import fstbank_ejb.util.OperationType;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Remote(CompteServiceRemote.class)
@Stateless
public class CompteServiceBean implements CompteServiceRemote{
   
    @EJB
    private CompteFactory compteFactory;
    @EJB
    private CompteAccessStrategyFactory compteAccessStrategyFactory;
    @EJB
    private IUserService userService;

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private ICompteObservable eventManager;

    @EJB
    private ICompteObserver transactionObserver;

    @PostConstruct
    public void init() {
        eventManager.attachClient(transactionObserver);
    }
  
    @Override
    public CompteBancaire ouvrirCompte(CompteType type, double soldeInitial) {

        CompteBancaire compte = compteFactory.createCompte(type);
        compte.setSolde(soldeInitial);

        entityManager.persist(compte);
        return compte;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Transaction> getTransactionsByCompte(Long compteId) {
        CompteBancaire compte = entityManager.find(CompteBancaire.class, compteId);
        compte.getTransactions().size(); // force le fetch
        return compte.getTransactions();
    }

    @Override
    public void retrait(Long userId, Long idCompte, double montant) {

        Users user = userService.findById(userId);  
        if (user == null) {
            throw new IllegalArgumentException("Utilisateur introuvable");
        }

        ICompteAccessStrategy strategy =
            compteAccessStrategyFactory.getStrategy(user);

        if (!strategy.canRetrait()) {
            throw new SecurityException("Accès refusé");
        }

        CompteBancaire compte =
            entityManager.find(CompteBancaire.class, idCompte);

        if (compte.getSolde() < montant) {
            throw new IllegalArgumentException("Solde insuffisant.");
        }

        compte.setSolde(compte.getSolde() - montant);
       
        eventManager.notifyObservers(compte, -montant,OperationType.RETRAIT);
    }


  
    @Override
    public void virement(Long userId, Long idSrc, Long idDest, double montant) {

       Users user = userService.findById(userId);  
        if (user == null) {
            throw new IllegalArgumentException("Utilisateur introuvable");
        }
        System.out.println("USER ID      : " + user.getId());
            System.out.println("USER TYPE    : " + user.getUserType());

            ICompteAccessStrategy strategy =
                compteAccessStrategyFactory.getStrategy(user);

            // 👇 ICI
            System.out.println("STRATEGY     : " + strategy.getClass().getSimpleName());
            System.out.println("CAN VIREMENT : " + strategy.canVirement());

        if (!strategy.canVirement()) {
            throw new SecurityException("Accès refusé");
        }

        CompteBancaire src = entityManager.find(CompteBancaire.class, idSrc);
        CompteBancaire dest = entityManager.find(CompteBancaire.class, idDest);

        if (src == null || dest == null) {
            throw new IllegalArgumentException("Compte source ou destination introuvable");
        }

        if (src.getSolde() < montant) {
            throw new IllegalArgumentException("Solde insuffisant");
        }

        src.setSolde(src.getSolde() - montant);
        dest.setSolde(dest.getSolde() + montant);
        
        // notify both account src and dest 
        eventManager.notifyObservers(src, -montant,OperationType.VIREMENT);
        eventManager.notifyObservers(dest, montant,OperationType.VIREMENT);
    }

   
        @Override
        public List<Transaction> consulterHistorique(Long userId, Long idCompte) {

             Users user = userService.findById(userId);  
            if (user == null) {
                throw new IllegalArgumentException("Utilisateur introuvable");
            }

            ICompteAccessStrategy strategy =
                compteAccessStrategyFactory.getStrategy(user);

            if (!strategy.canConsulterHistorique()) {
                throw new SecurityException("Accès refusé");
            }

            CompteBancaire compte = entityManager.find(CompteBancaire.class, idCompte);
            if (compte == null) {
                return Collections.emptyList();
            }

            // éviter LazyInitialization côté client
            compte.getTransactions().size();

            eventManager.notifyObservers(compte, compte.getSolde() ,OperationType.CONSULTER_HISTORIQUE);


            return compte.getTransactions();
        }


        @Override
        public void imprimerReleve(Long userId, Long idCompte) {

              Users user = userService.findById(userId); 
            if (user == null) {
                throw new IllegalArgumentException("Utilisateur introuvable");
            }

            ICompteAccessStrategy strategy =
                compteAccessStrategyFactory.getStrategy(user);

            if (!strategy.canImprimerReleve()) {
                throw new SecurityException("Accès refusé");
            }

            CompteBancaire compte = entityManager.find(CompteBancaire.class, idCompte);
            if (compte == null) {
                throw new IllegalArgumentException("Compte introuvable");
            }



            System.out.println("===== RELEVÉ DE COMPTE =====");
            System.out.println("Compte ID : " + compte.getId());
            System.out.println("Solde     : " + compte.getSolde());

            for (Transaction t : compte.getTransactions()) {
                System.out.println(
                    t.getDate() + " | " +
                    t.getOperationType() + " | " +
                    t.getMontant()
                );
            }

            System.out.println("============================");

            eventManager.notifyObservers(compte, compte.getSolde() ,OperationType.IMPRESSION_RELEVE);

        }




}
