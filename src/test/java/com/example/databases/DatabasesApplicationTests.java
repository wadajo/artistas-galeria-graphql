package com.example.databases;

import com.example.databases.model.Obra;
import com.example.databases.repository.ObraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class DatabasesApplicationTests {

	ObraRepository repository;
	List<Obra> obras;

	@BeforeEach
	void setUp() {
		repository=mock(ObraRepository.class);
		obras =Arrays.asList(new Obra(Long.parseLong("1"),"Java 1","Goetz",90.0),
				new Obra(Long.parseLong("2"),"Python","Furlong",99.0));
	}

	@Test
	void repositorySizeIsOk(){
		when(repository.findAll()).thenReturn(obras);

		assertThat(repository.findAll().size()).isEqualTo(2);
	}

}
