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
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    private Animal animal;

    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private RendezV rendezV;

    @ManyToOne
    private Prescription prescription;

    @ManyToOne
    private Type type;

    @Override
    public String toString() {
        return "Visit{" +
                "visitId=" + id +
                ", pet=" + animal.getNom() +
                ", doctor=" + medecin.getNom() +
                '}';
    }


}
