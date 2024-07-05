package com.isil.clinica.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "El nombre solo debe contener letras")
    @Column(name = "nombre")
    private String nombre;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "El apellido solo debe contener letras")
    @Column(name = "apellido")
    private String apellido;

    @Pattern(regexp = "^\\d+$", message = "El número de DNI solo deben ser números")
    @Column(name = "dni", length = 8)
    private String dni;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaNacimiento")
    private LocalDate FechaNacimiento;

    @Pattern(regexp = "^\\d+$", message = "El número de telefono solo acepta numeros")
    @Column(name = "telefono", length = 9)
    private String Telefono;

    @Column(name = "direccion")
    private String Direccion;
}
