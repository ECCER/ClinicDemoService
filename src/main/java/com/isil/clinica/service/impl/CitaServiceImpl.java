package com.isil.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isil.clinica.model.Cita;
import com.isil.clinica.model.Paciente;
import com.isil.clinica.repository.CitaRepository;
import com.isil.clinica.repository.PacienteRepository;
import com.isil.clinica.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    CitaRepository citaRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public List<Cita> getAllCitas() {
        
        return citaRepository.findAll();

    }

    @Override
    public Cita getCitaById(Integer id) {
        
        return citaRepository.findById(id).orElse(null);

    }

    @Override
    public Cita newCita(Cita cita) {

        return citaRepository.save(cita);

    }

    @Override
    public List<Cita> getCitaByPaciente(Integer id) {

        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        return citaRepository.findByPaciente(paciente);

    }

    @Override
    public Cita updateCita(Integer id, Cita cita) {
        
        Cita findCita = citaRepository.findById(id).orElse(null);

        if(findCita != null){
            cita.setId(id);
            return citaRepository.save(cita);
        }

        return null;

    }

    @Override
    public boolean deleteCita(Integer id) {
        
        Cita findCita = citaRepository.findById(id).orElse(null);

        if(findCita != null){
            citaRepository.deleteById(id);
            return true;
        }

        return false;

    }


}
