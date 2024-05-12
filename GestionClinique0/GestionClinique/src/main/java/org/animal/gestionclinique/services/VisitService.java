package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.Medecin;
import org.animal.gestionclinique.entities.Visit;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitService {
    Visit saveVisit(Visit visit);
    Visit UpdateVisit(Visit visit);
    void deleteVisit(Long id);
    void deleteAllVisit();
    Visit getVisitById(Long id);
    List<Visit> getAllVisit();
    Page<Visit> getAllVisitByPage(int page , int size);


}
