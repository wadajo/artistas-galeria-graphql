package com.example.galeria.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.Year;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="artistas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Artista {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "artista_id")
    private Long id;

    @Column
    @NotNull
    @NotBlank
    private String apellido;

    @Column
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer nacimiento;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.PERSIST)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<Obra> obras;
}
