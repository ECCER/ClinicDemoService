package com.isil.clinica.service;

import java.util.List;

import com.isil.clinica.model.Paciente;

public interface PacienteService {

    public List<Paciente> getAllPacientes();

    public Paciente getPacienteById(Integer id);

    public Paciente newPaciente(Paciente paciente);

    // public Paciente newVerifyPaciente(Paciente paciente);

    public Paciente updatePaciente(Integer id, Paciente paciente);

    public boolean deletePaciente(Integer id);

}
