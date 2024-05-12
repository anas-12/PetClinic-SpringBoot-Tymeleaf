package org.animal.gestionclinique;

import org.animal.gestionclinique.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GestionCliniqueApplication {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionCliniqueApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountService accountService) {
        return args -> {

            //accountService.createUser("admin","123","admin@gmail.com","123");
            //accountService.createUser("Medecin","123","medecin@gmail.com","123");



            //accountService.createRole("ADMIN");
            //accountService.createRole("Medecin");


            //accountService.addRoleToUser("admin", "ADMIN");
            // accountService.addRoleToUser("admin", "USER");
             //accountService.addRoleToUser("Medecin", "USER");


            //accountService.removeRoleFromUser("admin","ADMIN");




        };
    }

}
