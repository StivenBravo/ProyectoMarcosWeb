package com.libreria.miLibreria.Controller;

import com.libreria.miLibreria.Entitys.Libro;
import com.libreria.miLibreria.Repositories.CategoriaRepository;
import com.libreria.miLibreria.Repositories.LibroRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepo;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listarLibros(Model model) {
        model.addAttribute("libros", libroRepo.findAll());
        model.addAttribute("libro", new Libro());
        model.addAttribute("categorias",categoriaRepository.findAll());
        return "libros";
    }

    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute("libro") @Valid Libro libro,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("libro", libroRepo.findAll());
            model.addAttribute("categorias", categoriaRepository.findAll());
            return "libros";
        }
        libroRepo.save(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String editarLibro(@PathVariable Long id, Model model) {
        Libro libro = libroRepo.findById(id).orElseThrow();
        model.addAttribute("libro", libro);
        model.addAttribute("libros", libroRepo.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "libros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroRepo.deleteById(id);
        return "redirect:/libros";
    }
}
