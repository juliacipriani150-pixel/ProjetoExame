package com.exame.projeto_exame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exame.projeto_exame.model.Exame;
import com.exame.projeto_exame.service.ExameService;
import com.exame.projeto_exame.service.LaboratorioService;
import com.exame.projeto_exame.service.PacienteService;

@Controller
@RequestMapping("/exames")
public class ExameController {
    @Autowired
    private ExameService exameService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("exames", exameService.listarExame());
        return "lista_exame";
    }

    @GetMapping("/novo")
    public String NovaExame(Model model) {

        model.addAttribute("exame", new Exame());
        model.addAttribute("paciente", pacienteService.listarPaciente());
        model.addAttribute("laboratorio", laboratorioService.listarLaboratorio());
        return "form_exame";
    }

    @PostMapping
    public String salvarExame(@ModelAttribute Exame exame) {
        exameService.salvarExame(exame);
        return "lista_exame";
    }

    @GetMapping("/{id}/editar")
    public String editarExame(@PathVariable Long id, Model model) {
        Exame exame = exameService.buscarExame(id);
        model.addAttribute("exame", exame);
        model.addAttribute("paciente", pacienteService.listarPaciente());
        model.addAttribute("laboratorio", laboratorioService.listarLaboratorio());
        return "form_exame";

    }

    @GetMapping("/{id}/deletar")
    public String deletarExame(@PathVariable Long id) {
        exameService.deletarExame(id);
        return "lista_exame";
    }
}
