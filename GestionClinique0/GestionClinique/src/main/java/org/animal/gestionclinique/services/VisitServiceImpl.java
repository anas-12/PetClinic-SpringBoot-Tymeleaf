package org.animal.gestionclinique.services;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Visit;
import org.animal.gestionclinique.repositories.VisitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VisitServiceImpl implements VisitService{
    private VisitRepository visitRepository;
    @Override
    public Visit saveVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Visit UpdateVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void deleteVisit(Long id) {
visitRepository.deleteById(id);
    }

    @Override
    public void deleteAllVisit() {
visitRepository.deleteAll();
    }

    @Override
    public Visit getVisitById(Long id) {
        return visitRepository.findById(id).get();
    }

    @Override
    public List<Visit> getAllVisit() {
        return visitRepository.findAll();
    }

    @Override
    public Page<Visit> getAllVisitByPage(int page, int size) {
        return visitRepository.findAll(PageRequest.of(page,size));
    }
}
