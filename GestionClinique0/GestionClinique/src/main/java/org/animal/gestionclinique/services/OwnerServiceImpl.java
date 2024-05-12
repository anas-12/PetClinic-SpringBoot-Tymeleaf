package org.animal.gestionclinique.services;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Owner;
import org.animal.gestionclinique.repositories.OwnerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService{
    private OwnerRepository ownerRepository;
    @Override
    public Owner saveProprietaire(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner updateProprietaire(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteProprietaireById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public void deleteAllProprietaire() {
        ownerRepository.deleteAll();
    }

    @Override
    public Owner getProprietaireById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Owner> getAllProprietaires() {
       return ownerRepository.findAll();
    }

    @Override
    public Page<Owner> getAllProprietairesByPage(int page, int size) {
        return ownerRepository.findAll(PageRequest.of(page,size));
    }
    @Override
    public List<Owner> searchOwners(String query) {
        return ownerRepository.findByNomContainingIgnoreCase(query);
    }
}
