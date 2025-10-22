package com.exame.projeto_exame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exame.projeto_exame.model.Laboratorio;
import com.exame.projeto_exame.repository.LaboratorioRepository;

@Service
public class LaboratorioService {
    @Autowired
    private LaboratorioRepository laboratorioRepository;

    public List<Laboratorio> listarLaboratorio() {
        return laboratorioRepository.findAll();
    }

    public Laboratorio salvarLaboratorio(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    public Laboratorio buscarLaboratorio(Long id) {
        return laboratorioRepository.findById(id).orElse(null);
    }

    public void deletarLaboratorio(Long id) {
        laboratorioRepository.deleteById(id);
    }

}
