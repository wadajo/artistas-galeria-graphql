package com.example.galeria.controller;

import com.example.galeria.model.Artista;
import com.example.galeria.model.Obra;
import com.example.galeria.repository.ObraRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ObraGraphqlController {

    ObraRepository obraRepository;

    public ObraGraphqlController(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @QueryMapping
    public Flux<Obra> obras() {
        return Flux.fromIterable(obraRepository.findAll());
    }

    @QueryMapping
    public Flux<Obra> obrasPorArtista(@Argument String apellidoArtista) {
        return Flux.fromIterable(obraRepository.findAllByArtista(apellidoArtista));
    }

    @MutationMapping
    public Mono<Obra> addObra(@Argument ObraInput nueva){
        Obra aGuardar= Obra.builder()
                .titulo(nueva.titulo())
                .artista(Artista.builder().apellido(nueva.artista()).build())
                .precio(nueva.precio())
                .build();
        return Mono.just(obraRepository.save(aGuardar));
    }

}

record ObraInput(String titulo, String artista, double precio){}
