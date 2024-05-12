package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.Clinique;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CliniqueService {
    Clinique saveClinique(Clinique clinique);
    Clinique updateClinique(Clinique clinique);
    void deleteCliniqueById(Long id);
    void deleteAllClinique();
    Clinique getCliniqueById(Long id);
    List<Clinique> getAllClinique();
    Page<Clinique>getAllCliniquesByPage(int page, int size);

}
