package com.isil.clinica.controller;

import org.springframework.web.bind.annotation.RestController;

import com.isil.clinica.model.Paciente;
import com.isil.clinica.service.PacienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> getListPacientes() {
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable("id") Integer id) {

        Paciente paciente = pacienteService.getPacienteById(id);
        if(paciente != null){
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<?> newPaciente(@RequestBody Paciente paciente) {
        
        try{
            Paciente newPaciente = pacienteService.newPaciente(paciente);
            return new ResponseEntity<>(newPaciente, HttpStatus.OK);
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable("id") Integer id, @RequestBody Paciente paciente) {
        
        Paciente pacienteToUpdate = pacienteService.updatePaciente(id, paciente);

        if(pacienteToUpdate != null){
            return new ResponseEntity<>(pacienteToUpdate, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    
    
    

}
