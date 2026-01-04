package fstbank_ejb.interfaces;

import fstbank_ejb.entity.Users;
import jakarta.ejb.Local;

@Local
public interface IUserService {
      public Users save(Users user);
      public Users findById(Long id);
}
