package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.Prescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrescriptionService {
    Prescription savePrescription(Prescription prescription);
    Prescription updatePrescription(Prescription prescription);
    void deletePrescription(Long id);
    void deleteAllPrescription();
    Prescription getPrescriptionById(Long id);
    List<Prescription> getAllPrescription();

}
