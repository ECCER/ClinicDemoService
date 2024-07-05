package com.isil.clinica.service;

import java.util.List;

import com.isil.clinica.model.Cita;

public interface CitaService {

    public List<Cita> getAllCitas();

    public Cita getCitaById(Integer id);

    public List<Cita> getCitaByPaciente(Integer id);

    public Cita newCita(Cita cita);

    public Cita updateCita(Integer id, Cita cita);

    public boolean deleteCita(Integer id);

}
