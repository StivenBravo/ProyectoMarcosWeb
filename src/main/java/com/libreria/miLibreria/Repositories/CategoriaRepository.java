package com.libreria.miLibreria.Repositories;

import com.libreria.miLibreria.Entitys.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}