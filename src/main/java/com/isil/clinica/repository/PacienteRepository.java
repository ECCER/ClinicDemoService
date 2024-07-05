package com.isil.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isil.clinica.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    boolean existsByNombreAndApellido(String nombre, String apellido);

    boolean existsByDni(String dni);

}
