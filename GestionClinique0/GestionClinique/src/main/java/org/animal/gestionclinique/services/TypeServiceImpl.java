package org.animal.gestionclinique.services;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Type;
import org.animal.gestionclinique.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {
    private TypeRepository typeRepository;

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type updateType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public void deleteType(Long id) {
typeRepository.deleteById(id);
    }

    @Override
    public void deleteAllType() {
typeRepository.deleteAll();
    }

    @Override
    public Type getTypeById(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public List<Type> getAllType() {
        return typeRepository.findAll();
    }
}
