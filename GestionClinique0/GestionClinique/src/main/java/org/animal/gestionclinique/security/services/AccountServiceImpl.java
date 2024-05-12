package org.animal.gestionclinique.security.services;

import jakarta.transaction.Transactional;
import org.animal.gestionclinique.security.entities.Role;
import org.animal.gestionclinique.security.entities.User;
import org.animal.gestionclinique.security.repositories.RoleRepository;
import org.animal.gestionclinique.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
  @Autowired
  PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public User createUser(String usename, String password, String email, String confirmpassword) {
        /*
       User user1 = new User();
       user1.setUserId(UUID.randomUUID().toString());
       user1.setUsername(usename);
       user1.setPassword(passwordEncoder.encode(password));
       user1.setEmail(email);
       userRepository.save(user1);
        return null;*/
        User user1=userRepository.findByUsername(usename);
        if(user1!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmpassword)) throw new RuntimeException("Passwords do not match");

                 user1 = User.builder()
                .userId(UUID.randomUUID().toString())
                .username(usename)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        return userRepository.save(user1);
    }

    @Override
    public Role createRole(String newRole) {
        Role role1=roleRepository.findByRole(newRole);
        if(role1!=null) throw new RuntimeException("Role already exists");
                role1=Role.builder()
                .role(newRole)
                .build();
        return roleRepository.save(role1);
    }

    @Override
    public void addRoleToUser(String usename, String newRole) {
        User user1=userRepository.findByUsername(usename);
        Role role1=roleRepository.findByRole(newRole);
        user1.getRoles().add(role1);

    }

    @Override
    public void removeRoleFromUser(String usename, String newRole) {
        User user1=userRepository.findByUsername(usename);
        Role role1=roleRepository.findByRole(newRole);
        user1.getRoles().remove(role1);

    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
