package com.example.galeria.repository;

import com.example.galeria.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ObraRepository extends JpaRepository<Obra,Long> {
    Collection<Obra> findAllByArtista(String artista);
}
