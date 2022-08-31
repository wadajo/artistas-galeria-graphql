package com.example.galeria.controller;

import com.example.galeria.model.Artista;
import com.example.galeria.model.Obra;
import com.example.galeria.repository.ArtistaRepository;
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
    ArtistaRepository artistaRepository;

    public ObraGraphqlController(ObraRepository obraRepository, ArtistaRepository artistaRepository) {
        this.obraRepository = obraRepository;
        this.artistaRepository = artistaRepository;
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
        Artista existente=artistaRepository.findByApellido(nueva.artista()).orElseGet(()-> Artista.builder().apellido("").build());
        Artista nuevo=existente.getApellido().equals(nueva.artista())?
                Artista.builder().build():
                artistaRepository.save(Artista.builder().apellido(nueva.artista()).build());
        Artista deLaObra=existente.getApellido().equals(nueva.artista())?
            existente:
            nuevo;
        Obra aGuardar= Obra.builder()
                .titulo(nueva.titulo())
                .artista(deLaObra)
                .precio(nueva.precio())
                .build();
        return Mono.just(obraRepository.save(aGuardar));
    }

}

record ObraInput(String titulo, String artista, double precio){}
