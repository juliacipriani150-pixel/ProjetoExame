package com.exame.projeto_exame.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exame.projeto_exame.model.Exame;
import com.exame.projeto_exame.model.Paciente;
import com.exame.projeto_exame.service.ExameService;
import com.exame.projeto_exame.service.PacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private ExameService exameService;

    @GetMapping
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.listarPaciente(); // Listar todos os pacientes
        for (Paciente paciente : pacientes) {

            // Carregar os filhos para cada mãe
            List<Exame> exames = exameService.getExameByPacienteId(paciente.getId());
            paciente.setExame(exames); // Associar a lista de exames à pacintes
        }
        model.addAttribute("pacientes", pacientes); // Passar os pacientes e seus exames para o template
        return "lista_paciente"; // Retorna para o template de listar-pacientes
    }

    @GetMapping("/novo")
    public String novoPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "form_paciente";
    }

    @PostMapping
    public String salvarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.salvarPaciente(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/{id}/editar")
    public String editarPaciente(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.buscarPaciente(id);
        model.addAttribute("paciente", paciente);
        return "form_paciente";
    }

    @GetMapping("/{id}/deletar")
    public String deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return "redirect:/pacientes";
    }
}
