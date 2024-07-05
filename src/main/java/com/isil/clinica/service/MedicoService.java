package com.isil.clinica.service;

import java.util.List;

import com.isil.clinica.model.Medico;

public interface MedicoService {

    public List<Medico> getAllMedicos();

    public Medico getMedicoById(Integer id);

    public Medico newMedico(Medico medico);

    public Medico updateMedico(Integer id, Medico medico);

    public boolean deleteMedico(Integer id);

}
