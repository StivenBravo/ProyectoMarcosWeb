package com.libreria.miLibreria.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Libro {
    @ManyToOne
    @JoinColumn(name="categoria_id")
    @NotNull(message = "Selecciones una categoria valida")
    private Categoria categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @Min(value = 1800, message = "El año debe ser mayor que 1800")
    private int anio;


}

