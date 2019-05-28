package com.jojeda.servidor_character_builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/personajes")
    public List<Personaje> getPersonajes() {
        return personajeRepository.findAll();
    }

    @RequestMapping("/get_personaje")
    public Personaje getPersonaje(long id) {
        return personajeRepository.findById(id);
    }

    @Transactional
    @RequestMapping("/eliminar_personaje")
    public void eliminarPersonaje(@RequestParam(value="id") long id) {
        personajeRepository.deleteById(id);
    }

    @RequestMapping("/guardar_personaje")
    public void guardarPersonaje(
            @RequestParam(value="id") long id,
            @RequestParam(value="nombre") String nombre,
            @RequestParam(value="raza") String raza,
            @RequestParam(value="clase") String clase,
            @RequestParam(value="nivel") int nivel,
            @RequestParam(value="atributos") String atributos
    ) {
        Personaje personaje = new Personaje();
        personaje.setId(id);
        personaje.setNombre(nombre);
        personaje.setRaza(Personaje.Raza.valueOf(raza));
        personaje.setClase(Personaje.Clase.valueOf(clase));
        personaje.setNivel(nivel);
        personaje.setAtributos(atributos);
        personajeRepository.save(personaje);
    }

    @RequestMapping("/registrar_usuario")
    public void registrarUsuario(
            @RequestParam(value="id") long id,
            @RequestParam(value="nombre") String nombre,
            @RequestParam(value="contrasena") String contrasena
    ) {
        System.out.println("Registrar usuario");
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setContrasena(contrasena);
        usuarioRepository.save(usuario);
    }

    @RequestMapping("/iniciar_sesion")
    public Usuario iniciarSesion(
            @RequestParam(value="nombre") String nombre,
            @RequestParam(value="contrasena") String contrasena
    ) {
        System.out.println("Iniciar sesion");
        return usuarioRepository.findByNombreAndContrasena(nombre, contrasena);
    }
}
