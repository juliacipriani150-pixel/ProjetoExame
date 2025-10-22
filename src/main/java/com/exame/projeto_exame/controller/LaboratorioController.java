package com.exame.projeto_exame.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.exame.projeto_exame.model.Laboratorio;
import com.exame.projeto_exame.service.LaboratorioService;

@Controller
@RequestMapping("/laboratorios")
public class LaboratorioController {

    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping
    public String listarLaboratorio(Model model) {
        List<Laboratorio> laboratorio = laboratorioService.listarLaboratorio();
        model.addAttribute("laboratorio", laboratorio);
        return "lista_laboratorio";
    }

    @GetMapping("/novo")
    public String novoLaboratorio(Model model) {
        model.addAttribute("laboratorio", new Laboratorio());
        return "form_laboratorio";
    }

    @PostMapping 
    public String salvarLaboratorio(@ModelAttribute Laboratorio laboratorio) {
        laboratorioService.salvarLaboratorio(laboratorio);
        return "redirect:/laboratorios";
    }

    @GetMapping("/{id}/editar")
    public String editarLaboratorio(@PathVariable Long id, Model model) {
        Laboratorio laboratorio = laboratorioService.buscarLaboratorio(id);
        model.addAttribute("laboratorio", laboratorio);
        return "form_laboratorio";
    }

    @GetMapping("/{id}/deletar")
    public String deletarLaboratorio(@PathVariable Long id) {
        laboratorioService.deletarLaboratorio(id);
        return "redirect:/laboratorios";
    }
}

