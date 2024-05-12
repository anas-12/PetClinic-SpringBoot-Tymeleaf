package org.animal.gestionclinique.repositories;

import org.animal.gestionclinique.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<Medecin,Long> {
}
