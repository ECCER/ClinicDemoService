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

import com.isil.clinica.model.Cita;
import com.isil.clinica.service.CitaService;

@RestController
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    CitaService citaService;

    @GetMapping
    public ResponseEntity<List<Cita>> getListCitas() {
        List<Cita> citas = citaService.getAllCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<Cita>> getListCitasByPaciente(@PathVariable("id") Integer id){
        List<Cita> citas = citaService.getCitaByPaciente(id);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCita(@PathVariable("id") Integer id) {

        Cita cita = citaService.getCitaById(id);
        if(cita != null){
            return new ResponseEntity<>(cita, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<Cita> newCita(@RequestBody Cita cita) {
        
        Cita newCita = citaService.newCita(cita);
        return new ResponseEntity<>(newCita, HttpStatus.OK);

    }

    @PostMapping("/{id}")
    public ResponseEntity<Cita> updateCita(@PathVariable("id") Integer id, @RequestBody Cita cita) {
        
        Cita citaToUpdate = citaService.updateCita(id, cita);

        if(citaToUpdate != null){
            return new ResponseEntity<>(citaToUpdate, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
