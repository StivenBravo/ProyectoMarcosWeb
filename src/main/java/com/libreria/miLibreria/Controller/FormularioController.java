package com.libreria.miLibreria.Controller;
import com.libreria.miLibreria.Entitys.Formulario;
import com.libreria.miLibreria.Repositories.CategoriaRepository;
import com.libreria.miLibreria.Repositories.FormularioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormularioController {

    @Autowired
    private FormularioRepository formularioRepo;

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("formulario", new Formulario());
        return "formulario";
    }

    @GetMapping("/formularios")
    public String listarFormularios(Model model) {
        model.addAttribute("formularios", formularioRepo.findAll());
        return "formularios";
    }

    @PostMapping("/formulario")
    public String procesarFormulario(@ModelAttribute("formulario") @Valid Formulario formulario,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            return "formulario";
        }

        formularioRepo.save(formulario);
        model.addAttribute("mensaje", "Formulario enviado correctamente.");
        return "resultado";
    }
}
