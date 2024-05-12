package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.Clinique;
import org.animal.gestionclinique.repositories.CliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CliniqueServiceImpl implements CliniqueService {
    private CliniqueRepository cliniqueRepository;
    @Autowired
    public CliniqueServiceImpl(CliniqueRepository cliniqueRepository) {
        this.cliniqueRepository = cliniqueRepository;
    }

    @Override
    public Clinique saveClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Clinique updateClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public void deleteCliniqueById(Long id) {
        cliniqueRepository.deleteById(id);
    }

    @Override
    public void deleteAllClinique() {
        cliniqueRepository.deleteAll();
    }

    @Override
    public Clinique getCliniqueById(Long id) {
        return cliniqueRepository.findById(id).orElse(null);
    }

    @Override
    public List<Clinique> getAllClinique() {
        return cliniqueRepository.findAll();
    }

    @Override
    public Page<Clinique> getAllCliniquesByPage(int page, int size) {
        return  cliniqueRepository.findAll(PageRequest.of(page,size));
    }
}
