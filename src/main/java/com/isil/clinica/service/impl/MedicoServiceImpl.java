package com.isil.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isil.clinica.model.Medico;
import com.isil.clinica.repository.MedicoRepository;
import com.isil.clinica.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public List<Medico> getAllMedicos() {
        
        return medicoRepository.findAll();

    }

    @Override
    public Medico getMedicoById(Integer id) {
        
        return medicoRepository.findById(id).orElse(null);

    }

    @Override
    public Medico newMedico(Medico medico) {

        if( medicoRepository.existsByCpp(medico.getCpp())){
            throw new IllegalArgumentException("Ya existe un medico con el mismo codigo cpp");
        } else if (medicoRepository.existsByDni(medico.getDni())) {
            throw new IllegalArgumentException("Ya existe un medico con el ese DNI");
        } else if (medicoRepository.existsByNombreAndApellido(medico.getNombre(), medico.getApellido())){
            throw new IllegalArgumentException("Ya existe un medico con ese nombre y apellido");
        } else {
            return medicoRepository.save(medico);
        }
        
    }

    @Override
    public Medico updateMedico(Integer id, Medico medico) {
        
        Medico findMedico = medicoRepository.findById(id).orElse(null);

        if(findMedico != null){
            medico.setId(id);
            return medicoRepository.save(medico);
        }

        return null;

    }

    @Override
    public boolean deleteMedico(Integer id) {
        
        Medico findMedico = medicoRepository.findById(id).orElse(null);

        if(findMedico != null){
            medicoRepository.deleteById(id);
            return true;
        }

        return false;

    }

}
