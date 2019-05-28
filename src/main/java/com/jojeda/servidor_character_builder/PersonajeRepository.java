package com.jojeda.servidor_character_builder;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonajeRepository extends CrudRepository<Personaje, Integer> {

    List<Personaje> findAll();
    Personaje findById(long id);
    void deleteById(long id);
}
