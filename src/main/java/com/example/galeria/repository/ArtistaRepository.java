package com.example.galeria.repository;

import com.example.galeria.model.Artista;
import com.example.galeria.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista,Long> {

    Optional<Artista> findByApellido(String apellido);
}
