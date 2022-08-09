package com.example.databases.controller;

import com.example.databases.model.Libro;
import com.example.databases.repository.LibroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LibroController {

    LibroRepository repository;

    public LibroController(LibroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/libros")
    @Transactional(readOnly = true)
    public ResponseEntity<List<Libro>> todosLosLibros(){
        List<Libro> todos= repository.findAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

}
