package com.example.databases.controller;

import com.example.databases.model.Obra;
import com.example.databases.repository.ObraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class ObraController {

    ObraRepository repository;

    public ObraController(ObraRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/obras")
    @Transactional(readOnly = true)
    public ResponseEntity<List<Obra>> todasLasObras(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/obras")
    @Transactional
    public ResponseEntity<Obra> altaObra(@Valid @RequestBody Obra nueva){
        Obra guardado=repository.findById(repository.save(nueva).getId()).orElseThrow(NoSuchElementException::new);
        return new ResponseEntity<>(guardado,HttpStatus.CREATED);
    }

}
