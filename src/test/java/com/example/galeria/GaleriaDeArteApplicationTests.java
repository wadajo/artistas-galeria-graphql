package com.example.galeria;

import com.example.galeria.model.Artista;
import com.example.galeria.model.Obra;
import com.example.galeria.repository.ObraRepository;
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
class GaleriaDeArteApplicationTests {

	ObraRepository repository;
	List<Obra> obras;

	@BeforeEach
	void setUp() {
		repository=mock(ObraRepository.class);
		obras =Arrays.asList(
				Obra.builder().artista(Artista.builder().apellido("Picasso").build()).titulo("Mujer con sombrero").precio(120000.0).build(),
				Obra.builder().artista(Artista.builder().apellido("Miró").build()).titulo("Pájaro").precio(160000.0).build());
	}

	@Test
	void repositorySizeIsOk(){
		when(repository.findAll()).thenReturn(obras);

		assertThat(repository.findAll().size()).isEqualTo(2);
	}

}
