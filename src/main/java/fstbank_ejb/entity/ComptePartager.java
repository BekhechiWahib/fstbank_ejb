package fstbank_ejb.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;


@Entity
public class ComptePartager extends CompteBancaire {
    
    @ManyToMany
    private List<Client> listClientsPartages = new ArrayList<>();

}
