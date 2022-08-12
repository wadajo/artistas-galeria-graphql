package com.example.galeria.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="galerias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Galeria {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    @NotNull
    @NotBlank
    private String nombre;

    @OneToMany(mappedBy = "galeria")
    private Collection<Obra> obras;
}
