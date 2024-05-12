package org.animal.gestionclinique.security.services;

import org.animal.gestionclinique.security.entities.Role;
import org.animal.gestionclinique.security.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    User createUser(String usename, String password,String email,String confirmpassword);
    Role createRole(String newRole);
    void addRoleToUser(String usename, String newRole);
    void removeRoleFromUser(String usename, String newRole);
    User loadUserByUsername(String username);
}
