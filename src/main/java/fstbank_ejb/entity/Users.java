package fstbank_ejb.entity;
import fstbank_ejb.util.UserType;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Long getId() { return id; }  public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }  public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }  public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresse() { return adresse; } public void setAdresse(String adresse) { this.adresse = adresse; }
    
    public UserType getUserType() { return userType; } public void setUserType(UserType userType) { this.userType = userType; }
    
}
