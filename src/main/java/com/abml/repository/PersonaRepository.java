/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.abml.repository;
import com.abml.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Home
 */

// la interface extiende de JpaRepository (que maneja repositorios JPA)
// en los parámetros <> deben ir: <clase a persistir, tipo de dato de su ID>
@Repository // mapeamos como repositorio
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
}
