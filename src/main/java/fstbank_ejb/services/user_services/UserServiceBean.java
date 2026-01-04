package fstbank_ejb.services.user_services;

import fstbank_ejb.entity.Users;
import fstbank_ejb.interfaces.IUserService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserServiceBean implements IUserService{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Users save(Users user) {
        em.persist(user);
        return user;
    }

    @Override
    public Users findById(Long id) {
        return em.find(Users.class, id);
    }
}
