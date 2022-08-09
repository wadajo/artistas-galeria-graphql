package com.example.databases.controller;

import com.example.databases.model.Libro;
import com.example.databases.repository.LibroRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

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
}
