package com.libreria.miLibreria.Entitys;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "formulario")
@Getter
@Setter
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Min(value = 1, message = "La edad debe ser mayor a 0")
    private int edad;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe ser válido")
    private String correo;
}
