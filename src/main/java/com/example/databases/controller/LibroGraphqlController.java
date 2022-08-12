package com.example.databases.controller;

import com.example.databases.model.Libro;
import com.example.databases.repository.LibroRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.NoSuchElementException;

@Controller
public class LibroGraphqlController {

    LibroRepository repository;

    public LibroGraphqlController(LibroRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public Collection<Libro> libros() {
        return repository.findAll();
    }

    @MutationMapping
    public Libro addLibro(@Argument LibroInput nuevo){
        Libro aGuardar=Libro.builder()
                .titulo(nuevo.titulo())
                .autor(nuevo.autor())
                .precio(nuevo.precio())
                .build();
        return repository.save(aGuardar);
    }
}

record LibroInput(String titulo, String autor, double precio){}
