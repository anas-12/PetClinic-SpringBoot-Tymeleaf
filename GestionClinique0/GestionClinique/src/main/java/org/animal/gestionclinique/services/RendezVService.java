package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.RendezV;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface RendezVService {

    RendezV saveRendezV(RendezV rendezV);

    RendezV updateRendezV(RendezV rendezV);

    void deleteRendezVById(Long id); // Assuming id is int in RendezV

    void deleteAllRendezVs();

    RendezV getRendezVById(Long id); // Assuming id is int in RendezV

    List<RendezV> getAllRendezVs();

    Page<RendezV> getAllRendezVsByPage(int page, int size);

    public RendezV getRendezVByDate(LocalDate dateRDV);
}
