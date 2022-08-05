package com.example.databases;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LibroController {

    LibroRepository repository;

    public LibroController(LibroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> todosLosLibros(){
        List<Libro> todos= repository.findAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

}
