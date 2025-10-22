package com.exame.projeto_exame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exame.projeto_exame.model.Exame;
import com.exame.projeto_exame.repository.ExameRepository;

@Service
public class ExameService {
    @Autowired
    private ExameRepository exameRepository;

    public List<Exame> listarExame() {
        return exameRepository.findAll();
    }

    public List<Exame> getExameByPacienteId(Long pacienteId) {
        return exameRepository.findByPacienteId(pacienteId);
    }

    public Exame salvarExame(Exame exame) {
        return exameRepository.save(exame);
    }

    public Exame buscarExame(Long id) {
        return exameRepository.findById(id).orElse(null);
    }

    public void deletarExame(Long id) {
        exameRepository.deleteById(id);
    }

}
