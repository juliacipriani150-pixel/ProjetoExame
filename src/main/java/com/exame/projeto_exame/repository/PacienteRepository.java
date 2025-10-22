package com.exame.projeto_exame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exame.projeto_exame.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
