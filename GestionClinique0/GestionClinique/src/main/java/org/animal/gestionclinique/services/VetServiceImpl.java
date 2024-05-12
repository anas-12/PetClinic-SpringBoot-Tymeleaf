package org.animal.gestionclinique.services;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Medecin;
import org.animal.gestionclinique.repositories.VetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class VetServiceImpl implements VetService{
    private VetRepository vetRepository;
    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return vetRepository.save(medecin);
    }

    @Override
    public Medecin updateMedecin(Medecin medecin) {
        return  vetRepository.save(medecin);
    }

    @Override
    public void deleteMedecin(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public void deleteAllMedecin() {
        vetRepository.deleteAll();
    }

    @Override
    public Medecin getMedecinById(Long id) {
        return vetRepository.findById(id).get();
    }

    @Override
    public List<Medecin> getAllMedecin() {
        return vetRepository.findAll();
    }

    @Override
    public Page<Medecin> getAllProprietairesByPage(int page, int size) {
        return vetRepository.findAll(PageRequest.of(page,size));

    }
}
