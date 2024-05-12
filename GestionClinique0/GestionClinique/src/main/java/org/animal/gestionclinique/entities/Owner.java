package org.animal.gestionclinique.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.util.Lazy;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Error Fname")
    private String nom;
    private String lastname;
    private String address;
    private String ville;
    @NotBlank(message = "Error phone")
    private String telephone;

    @OneToMany(mappedBy = "owner",fetch = FetchType.LAZY)
    private List<Animal> animals=new ArrayList<>();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + nom + '\'' +
                '}';
    }

}
