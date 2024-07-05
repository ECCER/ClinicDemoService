package com.isil.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isil.clinica.model.Medico;
import com.isil.clinica.service.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> getListMedicos() {
        List<Medico> medicos = medicoService.getAllMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedico(@PathVariable("id") Integer id) {

        Medico medico = medicoService.getMedicoById(id);
        if(medico != null){
            return new ResponseEntity<>(medico, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<?> newMedico(@Valid @RequestBody Medico medico) {

        try {
            Medico newMedico = medicoService.newMedico(medico);
            return new ResponseEntity<>(newMedico, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable("id") Integer id, @RequestBody Medico medico) {
        
        Medico medicoToUpdate = medicoService.updateMedico(id, medico);

        if(medicoToUpdate != null){
            return new ResponseEntity<>(medicoToUpdate, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
