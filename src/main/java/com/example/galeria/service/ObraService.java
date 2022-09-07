package com.example.galeria.service;

import com.example.galeria.model.Artista;
import com.example.galeria.model.Obra;
import com.example.galeria.model.ObraInput;
import com.example.galeria.repository.ArtistaRepository;
import com.example.galeria.repository.ObraRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ObraService {

    ArtistaRepository artistaRepository;
    ObraRepository obraRepository;

    public ObraService(ArtistaRepository artistaRepository, ObraRepository obraRepository) {
        this.artistaRepository = artistaRepository;
        this.obraRepository = obraRepository;
    }

    public Mono<Obra> guardarObra(ObraInput aGuardar){
        Artista existente=artistaRepository.findByApellido(aGuardar.artista()).orElseGet(()-> Artista.builder().apellido("").build());
        Artista nuevo=existente.getApellido().equals(aGuardar.artista())?
                Artista.builder().build():
                artistaRepository.save(Artista.builder().apellido(aGuardar.artista()).build());
        Artista deLaObra=existente.getApellido().equals(aGuardar.artista())?
                existente:
                nuevo;
        Obra nueva= Obra.builder()
                .titulo(aGuardar.titulo())
                .artista(deLaObra)
                .precio(aGuardar.precio())
                .build();
        return Mono.just(obraRepository.save(nueva));
    }
}
