package com.isil.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isil.clinica.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer>{

    boolean existsByNombreAndApellido( String nombre, String Aoellido);

    boolean existsByDni(String dni);

    boolean existsByCpp(String cpp);

}
