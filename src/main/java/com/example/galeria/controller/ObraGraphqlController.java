package com.example.galeria.controller;

import com.example.galeria.model.Galeria;
import com.example.galeria.model.Obra;
import com.example.galeria.repository.GaleriaRepository;
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
    GaleriaRepository galeriaRepository;

    public ObraGraphqlController(ObraRepository obraRepository, GaleriaRepository galeriaRepository) {
        this.obraRepository = obraRepository;
        this.galeriaRepository = galeriaRepository;
    }

    @QueryMapping
    public Flux<Obra> obras() {
        return Flux.fromIterable(obraRepository.findAll());
    }

    @QueryMapping
    public Flux<Obra> obrasPorArtista(@Argument String artista) {
        return Flux.fromIterable(obraRepository.findAllByArtista(artista));
    }

    @MutationMapping
    public Mono<Obra> addObra(@Argument ObraInput nueva){
        Obra aGuardar= Obra.builder()
                .titulo(nueva.titulo())
                .artista(nueva.artista())
                .precio(nueva.precio())
                .build();
        return Mono.just(obraRepository.save(aGuardar));
    }

    @QueryMapping
    public Flux<Galeria> galerias(){
        return Flux.fromIterable(galeriaRepository.findAll());
    }
}

record ObraInput(String titulo, String artista, double precio){}
