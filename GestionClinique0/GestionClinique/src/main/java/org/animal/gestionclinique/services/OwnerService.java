package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.Owner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {
    Owner saveProprietaire(Owner owner);
    Owner updateProprietaire(Owner owner);
    void deleteProprietaireById(Long id);
    void deleteAllProprietaire();
    Owner getProprietaireById(Long id);
    List<Owner> getAllProprietaires();
    Page<Owner> getAllProprietairesByPage(int page , int size);
    public List<Owner> searchOwners(String query);


}
