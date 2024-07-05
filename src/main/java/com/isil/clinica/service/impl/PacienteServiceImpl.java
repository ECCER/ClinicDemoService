package com.isil.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isil.clinica.model.Paciente;
import com.isil.clinica.repository.PacienteRepository;
import com.isil.clinica.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getAllPacientes() {
        
        return pacienteRepository.findAll();

    }

    @Override
    public Paciente getPacienteById(Integer id) {
        
        return pacienteRepository.findById(id).orElse(null);

    }

    @Override
    public Paciente newPaciente(Paciente paciente) {

        if(pacienteRepository.existsByDni(paciente.getDni())){
            throw new IllegalArgumentException("Ya existe un paciente con ese dni");
        } else if(pacienteRepository.existsByNombreAndApellido(paciente.getNombre(), paciente.getApellido())){
            throw new IllegalArgumentException("Ya existe un paciente con ese nombre");
        } else {
            return pacienteRepository.save(paciente);
        }
        

    }


    @Override
    public Paciente updatePaciente(Integer id, Paciente paciente) {
        
        Paciente findPaciente = pacienteRepository.findById(id).orElse(null);

        if(findPaciente != null){
            paciente.setId(id);
            return pacienteRepository.save(paciente);
        }

        return null;

    }

    @Override
    public boolean deletePaciente(Integer id) {
        
        Paciente findPaciente = pacienteRepository.findById(id).orElse(null);

        if(findPaciente != null){
            pacienteRepository.deleteById(id);
            return true;
        }

        return false;

    }


}
