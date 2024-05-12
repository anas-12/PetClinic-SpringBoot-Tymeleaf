package org.animal.gestionclinique.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
       return httpSecurity
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authCustomizer -> authCustomizer
                                .requestMatchers("/editeOwner","deleteOwner","/updateOwner","deleteClinique","editVisit").hasRole("ADMIN")
                                .requestMatchers("/createOwner","/saveOwner").hasAnyRole("ADMIN")
                                .requestMatchers("/OwnersList","VetList","PetList","visitList").hasAnyRole("ADMIN")
                                .requestMatchers("/OwnersList","/CliniqueList.html","/VetList","/PetList","/visitList").hasAnyRole("Medecin")
                                .anyRequest().authenticated()
                )
               .exceptionHandling(e->e.accessDeniedPage("/accessDenied"))
        .build();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder.encode("123")).roles("ADMIN","USER").build(),
                User.withUsername("Medecin").password(passwordEncoder.encode("123")).roles("Medecin","USER").build()

                );
    }


}
