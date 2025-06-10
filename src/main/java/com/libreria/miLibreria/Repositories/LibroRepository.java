package com.libreria.miLibreria.Repositories;
import com.libreria.miLibreria.Entitys.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
