package com.example.galeria.repository;

import com.example.galeria.model.Galeria;
import com.example.galeria.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface GaleriaRepository extends JpaRepository<Galeria,Long> {

}
