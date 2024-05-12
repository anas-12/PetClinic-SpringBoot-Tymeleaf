package org.animal.gestionclinique.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String race;
    private int age;

    @ManyToOne
    private Owner owner;

    @OneToMany(mappedBy = "animal")
    private List<Visit> visits=new ArrayList<>();
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + nom + '\'' +
                '}';
    }


}
