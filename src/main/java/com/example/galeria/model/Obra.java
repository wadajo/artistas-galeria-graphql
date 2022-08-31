package com.example.galeria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static javax.persistence.GenerationType.IDENTITY;

@Entity (name="obras")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Obra {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "obra_id")
    private Long id;

    @Column
    @NotNull
    @NotBlank
    private String titulo;

    @Column
    @Positive(message = "El precio debe ser un número mayor que 0 (cero)")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "artista_id",referencedColumnName = "artista_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Artista artista;
}
