package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.RendezV;
import org.animal.gestionclinique.repositories.RendezvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RendezVServiceImpl implements RendezVService {

    @Autowired
    private RendezvRepository rendezVRepository;

    @Override
    public RendezV saveRendezV(RendezV rendezV) {
        return rendezVRepository.save(rendezV);
    }

    @Override
    public RendezV updateRendezV(RendezV rendezV) {
        return rendezVRepository.save(rendezV);
    }

    @Override
    public void deleteRendezVById(Long id) {
        rendezVRepository.deleteById(id);
    }

    @Override
    public void deleteAllRendezVs() {
        rendezVRepository.deleteAll();
    }

    @Override
    public RendezV getRendezVById(Long id) {
        return rendezVRepository.findById(id).orElse(null);
    }

    @Override
    public List<RendezV> getAllRendezVs() {
        return rendezVRepository.findAll();
    }

    @Override
    public Page<RendezV> getAllRendezVsByPage(int page, int size) {
        return rendezVRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public RendezV getRendezVByDate(LocalDate dateRDV) {
        return rendezVRepository.findByDateRDV(dateRDV);
    }
}
