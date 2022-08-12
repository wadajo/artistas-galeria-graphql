package com.example.databases.controller;

import com.example.databases.model.Obra;
import com.example.databases.repository.ObraRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ObraGraphqlController {

    ObraRepository repository;

    public ObraGraphqlController(ObraRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public Flux<Obra> obras() {
        return Flux.fromIterable(repository.findAll());
    }

    @QueryMapping
    public Flux<Obra> obrasPorArtista(@Argument String artista) {
        return Flux.fromIterable(repository.findAllByArtista(artista));
    }

    @MutationMapping
    public Mono<Obra> addObra(@Argument ObraInput nueva){
        Obra aGuardar= Obra.builder()
                .titulo(nueva.titulo())
                .artista(nueva.artista())
                .precio(nueva.precio())
                .build();
        return Mono.just(repository.save(aGuardar));
    }
}

record ObraInput(String titulo, String artista, double precio){}
