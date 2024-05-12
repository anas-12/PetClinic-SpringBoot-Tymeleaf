package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.Animal;
import org.animal.gestionclinique.repositories.PetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PetService {
    Animal saveAnimal(Animal animal);
    Animal updateAnimal(Animal animal);
    void deleteAnimalById(Long id);
    void deleteAllAnimals();
    Animal getAnimalById(Long id);
    List<Animal> getAllAnimals();
    Page<Animal> getAllAnimalsByPage(int page, int size);


}
