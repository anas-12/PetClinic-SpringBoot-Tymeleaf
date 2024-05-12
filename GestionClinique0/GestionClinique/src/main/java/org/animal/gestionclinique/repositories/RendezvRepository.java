package org.animal.gestionclinique.repositories;

import org.animal.gestionclinique.entities.RendezV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RendezvRepository extends JpaRepository<RendezV,Long> {
    RendezV findByDateRDV(LocalDate dateRDV);
}
