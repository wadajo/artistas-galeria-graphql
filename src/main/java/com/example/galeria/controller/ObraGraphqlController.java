package com.example.galeria.controller;

import com.example.galeria.model.Artista;
import com.example.galeria.model.ArtistaInput;
import com.example.galeria.model.Obra;
import com.example.galeria.model.ObraInput;
import com.example.galeria.repository.ArtistaRepository;
import com.example.galeria.repository.ObraRepository;
import com.example.galeria.service.ArtistaService;
import com.example.galeria.service.ObraService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class ObraGraphqlController {

    ObraRepository obraRepository;
    ArtistaRepository artistaRepository;
    ObraService obraService;
    ArtistaService artistaService;

    public ObraGraphqlController(ObraRepository obraRepository, ArtistaRepository artistaRepository, ObraService obraService, ArtistaService artistaService) {
        this.obraRepository = obraRepository;
        this.artistaRepository = artistaRepository;
        this.obraService = obraService;
        this.artistaService = artistaService;
    }

    @QueryMapping
    public Flux<Obra> obras() {
        return Flux.fromIterable(obraRepository.findAll());
    }

    @QueryMapping
    public Flux<Obra> obrasPorArtista(@Argument String apellidoArtista) {
        return Flux.fromIterable(obraRepository.findAllByApellidoArtista(apellidoArtista));
    }

    @QueryMapping
    public Flux<Artista> artistas() {
        return Flux.fromIterable(artistaRepository.findAll());
    }

    @MutationMapping
    public Mono<Obra> addObra(@Argument ObraInput nueva){
        return Mono.just(obraService.guardarObra(nueva));
    }

    @MutationMapping
    public Mono<Artista> updateArtista(@Argument ArtistaInput actualizado){
        return Mono.just(artistaService.actualizarDatos(actualizado)).doOnError(Throwable::printStackTrace);
    }

}

