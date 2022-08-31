package com.example.galeria.controller;

import com.example.galeria.model.Artista;
import com.example.galeria.model.Obra;
import com.example.galeria.repository.ObraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ObraController {

    ObraRepository obraRepository;

    public ObraController(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @GetMapping("/obras")
    @Transactional(readOnly = true)
    public ResponseEntity<List<Obra>> todasLasObras(){
        return ResponseEntity.ok(obraRepository.findAll());
    }

    @PostMapping("/obras")
    @Transactional
    public ResponseEntity<Obra> altaObra(@Valid @RequestBody Obra nueva){
        Obra guardado= obraRepository.findById(obraRepository.save(nueva).getId()).orElseThrow(NoSuchElementException::new);
        return new ResponseEntity<>(guardado,HttpStatus.CREATED);
    }

}
