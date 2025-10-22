package com.exame.projeto_exame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exame.projeto_exame.model.Paciente;
import com.exame.projeto_exame.repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarPaciente() {
        return pacienteRepository.findAll();
    }

    public Paciente salvarPaciente(Paciente laboratorio) {
        return pacienteRepository.save(laboratorio);
    }

    public Paciente buscarPaciente(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

}
