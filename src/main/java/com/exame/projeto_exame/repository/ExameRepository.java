package com.exame.projeto_exame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exame.projeto_exame.model.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {
    List<Exame> findByPacienteId(Long pacienteId);
    List<Exame> findByLaboratorioId(Long laboratorioId);

}
