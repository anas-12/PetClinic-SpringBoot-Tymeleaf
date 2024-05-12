package org.animal.gestionclinique.services;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Animal;
import org.animal.gestionclinique.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService{
    private PetRepository petRepository;

    @Override
    public Animal saveAnimal(Animal animal) {
        return petRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        return petRepository.save(animal);
    }

    @Override
    public void deleteAnimalById(Long id) {
    petRepository.deleteById(id);
    }

    @Override
    public void deleteAllAnimals() {
        petRepository.deleteAll();

    }

    @Override
    public Animal getAnimalById(Long id) {
        return petRepository.findById(id).get();
    }

    @Override
    public List<Animal> getAllAnimals() {
        return petRepository.findAll();
    }

    @Override
    public Page<Animal> getAllAnimalsByPage(int page, int size) {
        return petRepository.findAll(PageRequest.of(page,size));
    }
}
