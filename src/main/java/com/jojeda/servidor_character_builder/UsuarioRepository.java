package com.jojeda.servidor_character_builder;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByNombreAndContrasena(String nombre, String contrasena);
}
