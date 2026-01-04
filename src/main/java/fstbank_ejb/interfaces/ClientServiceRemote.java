package fstbank_ejb.interfaces;

import jakarta.ejb.Remote;
import java.util.List;
import fstbank_ejb.entity.CompteBancaire;

@Remote
public interface ClientServiceRemote {
    List<CompteBancaire> getListeComptes(Long clientId);
}
