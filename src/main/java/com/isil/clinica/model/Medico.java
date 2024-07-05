package com.isil.clinica.model;

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
@Table(name = "medico")
public class Medico {

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

    @Pattern(regexp = "^\\d+$", message = "El número de CPP solo deben ser números")
    @Column(name = "cpp")
    private String cpp;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "La especialidad solo debe contener letras")
    @Column(name = "especialidad")
    private String especialidad;

    @Pattern(regexp = "^\\d+$", message = "El número de telefono solo deben ser números")
    @Column(name = "telefono", length = 9)
    private String telefono;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Correo electrónico no válido")
    @Column(name = "email")
    private String email;

}
