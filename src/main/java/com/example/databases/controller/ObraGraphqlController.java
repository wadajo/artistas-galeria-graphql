package com.example.databases.controller;

import com.example.databases.model.Obra;
import com.example.databases.repository.ObraRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class ObraGraphqlController {

    ObraRepository repository;

    public ObraGraphqlController(ObraRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public Collection<Obra> obras() {
        return repository.findAll();
    }

    @QueryMapping
    public Collection<Obra> obrasPorArtista(@Argument String artista) {
        return repository.findAllByArtista(artista);
    }

    @MutationMapping
    public Obra addObra(@Argument ObraInput nueva){
        Obra aGuardar= Obra.builder()
                .titulo(nueva.titulo())
                .artista(nueva.artista())
                .precio(nueva.precio())
                .build();
        return repository.save(aGuardar);
    }
}

record ObraInput(String titulo, String artista, double precio){}
