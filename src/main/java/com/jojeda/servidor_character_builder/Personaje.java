package com.jojeda.servidor_character_builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


@Entity
@Table(name="personajes")
public class Personaje implements Serializable {

    public enum Raza {
        HUMANO, ELFO, ENANO, MEDIANO
    }
    public enum Clase {
        GUERRERO, MAGO, PALADIN, LADRON
    }

    // Atributos de clase

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nombre")
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name="raza")
    private Raza raza;

    @Enumerated(EnumType.STRING)
    @Column(name="clase")
    private Clase clase;

    @Column(name="nivel")
    private int nivel;

    @Column(name="atributos")
    private String atributos;

    // Inicializacion
    {
        raza = Raza.HUMANO;
        clase = Clase.GUERRERO;
    }

    public Personaje() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAtributos() {
        return atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
