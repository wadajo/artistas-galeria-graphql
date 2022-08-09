package com.example.databases;

import com.example.databases.model.Libro;
import com.example.databases.repository.LibroRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class DatabasesApplicationTests {

	LibroRepository repository;
	List<Libro> libros;

	@BeforeEach
	void setUp() {
		repository=mock(LibroRepository.class);
		libros=Arrays.asList(new Libro(Long.parseLong("1"),"Java 1","Goetz",90.0),
				new Libro(Long.parseLong("2"),"Python","Furlong",99.0));
	}

	@Test
	void repositorySizeIsOk(){
		when(repository.findAll()).thenReturn(libros);

		assertThat(repository.findAll().size()).isEqualTo(2);
	}
	@Test
	void repositorySizeIsOkWhenNewBookAdded(){
		when(repository.findAll()).thenReturn(libros);

		repository.save(new Libro(Long.parseLong("3"),"Scala","Hall",89.0));

		assertThat(repository.findAll().size()).isEqualTo(3);
	}

}
