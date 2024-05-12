package org.animal.gestionclinique.services;

import org.animal.gestionclinique.entities.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
    Type saveType(Type type);
    Type updateType(Type type);
    void deleteType(Long id);
    void deleteAllType();
    Type getTypeById(Long id);
    List<Type> getAllType();

}
