package org.animal.gestionclinique.repositories;

import org.animal.gestionclinique.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Animal,Long> {

}
