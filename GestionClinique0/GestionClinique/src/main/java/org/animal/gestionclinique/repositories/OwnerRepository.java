package org.animal.gestionclinique.repositories;

import org.animal.gestionclinique.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByNomContainingIgnoreCase(String nom);

}
