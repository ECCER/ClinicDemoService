package com.isil.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isil.clinica.model.Cita;
import com.isil.clinica.model.Paciente;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

    List<Cita> findByPaciente(Paciente paciente);
}
