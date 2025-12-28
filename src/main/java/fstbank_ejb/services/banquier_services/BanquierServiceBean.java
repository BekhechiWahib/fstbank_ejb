package fstbank_ejb.services.banquier_services;

import java.util.List;

import fstbank_ejb.entity.CompteBancaire;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class BanquierServiceBean {
   @PersistenceContext
    private EntityManager em;

    public Client creerClient(Client c) { }

    public CompteBancaire creerCompte(String type) { }

    public List<Transaction> consulterHistorique(Long idCompte) { } 
}
