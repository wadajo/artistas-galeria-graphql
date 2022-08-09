package com.example.databases.controller;

import com.example.databases.model.Libro;
import com.example.databases.repository.LibroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class LibroController {

    LibroRepository repository;

    public LibroController(LibroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/libros")
    @Transactional(readOnly = true)
    public ResponseEntity<List<Libro>> todosLosLibros(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/libros")
    @Transactional
    public ResponseEntity<Libro> altaLibro(@Valid @RequestBody Libro nuevo){
        Libro guardado=repository.findById(repository.save(nuevo).getId()).orElseThrow(NoSuchElementException::new);
        return new ResponseEntity<>(guardado,HttpStatus.CREATED);
    }

}
