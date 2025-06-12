package com.libreria.miLibreria.Controller;
import com.libreria.miLibreria.Entitys.Categoria;
import com.libreria.miLibreria.Repositories.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("categoria", new Categoria());
        return "categoria";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute("categorias") @Valid Categoria categoria,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaRepository.findAll());
            model.addAttribute("categoria", categoria);
            return "categoria";
        }
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        model.addAttribute("categoria", categoria);
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categoria";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
        return "redirect:/categorias";
    }
}
