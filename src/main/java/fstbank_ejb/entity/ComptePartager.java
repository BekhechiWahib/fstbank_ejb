package fstbank_ejb.entity;

import java.util.ArrayList;

import fstbank_ejb.interfaces.ICompteObservable;
import jakarta.persistence.Entity;

@Entity
public class ComptePartager extends CompteBancaire implements ICompteObservable{
    private ArrayList<Client> listsOfSubscribedClient;
}
