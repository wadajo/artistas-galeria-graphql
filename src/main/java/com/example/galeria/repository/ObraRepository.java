package com.example.galeria.repository;

import com.example.galeria.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ObraRepository extends JpaRepository<Obra,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM obras WHERE artista_id=(SELECT artista_id FROM artistas WHERE apellido=?)")
    Collection<Obra> findAllByApellidoArtista(String artista);
}
