package org.animal.gestionclinique.services;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Prescription;
import org.animal.gestionclinique.repositories.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {
    private PrescriptionRepository prescriptionRepository;
    @Override
    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription updatePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

    @Override
    public void deleteAllPrescription() {

    }

    @Override
    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id).get();
    }

    @Override
    public List<Prescription> getAllPrescription() {
        return prescriptionRepository.findAll();
    }
}
