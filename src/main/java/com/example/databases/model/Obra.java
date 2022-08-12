package com.example.databases.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private Long id;
    @Column
    @NotNull
    @NotBlank
    private String titulo;
    @Column
    @NotNull
    @NotBlank
    private String artista;
    @Column
    @Positive(message = "El precio debe ser un número mayor que 0 (cero)")
    private Double precio;
}
