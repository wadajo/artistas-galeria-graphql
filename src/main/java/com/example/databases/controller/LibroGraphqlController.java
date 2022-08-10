package com.example.databases.controller;

import com.example.databases.model.Libro;
import com.example.databases.repository.LibroRepository;
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
    public Libro addLibro(String titulo, String autor, Float precio){
        Libro nuevo=new Libro();
        nuevo.setAutor(autor);
        nuevo.setTitulo(titulo);
        nuevo.setPrecio(Double.parseDouble(precio.toString()));
        repository.save(nuevo);
        return repository.findById(nuevo.getId()).orElseThrow(()->new RuntimeException());
    }
}
