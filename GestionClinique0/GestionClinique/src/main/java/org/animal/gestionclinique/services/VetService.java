package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface VetService {
    Medecin saveMedecin(Medecin medecin);
    Medecin updateMedecin(Medecin medecin);
    void deleteMedecin(Long id);
    void deleteAllMedecin();
    Medecin getMedecinById(Long id);
    List<Medecin> getAllMedecin();
    Page<Medecin> getAllProprietairesByPage(int page , int size);

}
