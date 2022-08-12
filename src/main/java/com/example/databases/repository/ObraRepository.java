package com.example.databases.repository;

import com.example.databases.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ObraRepository extends JpaRepository<Obra,Long> {
    Collection<Obra> findAllByArtista(String artista);
}
