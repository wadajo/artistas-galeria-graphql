package com.example.galeria.service;

import com.example.galeria.model.Artista;
import com.example.galeria.model.ArtistaInput;
import com.example.galeria.repository.ArtistaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ArtistaService {
    public ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public Mono<Artista> actualizarDatos(ArtistaInput actualizado) throws RuntimeException {
        Artista encontrado = artistaRepository.findByApellido(actualizado.apellido()).orElseThrow(()->new RuntimeException("Excepción: artista no encontrado"));
        if(null!=actualizado.nacimiento())
            encontrado.setNacimiento(actualizado.nacimiento());
        return Mono.just(artistaRepository.save(encontrado));
    }
}
