/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.abml.service;
import com.abml.model.Persona;
import java.util.List;

/**
 *
 * @author Home
 */
public interface IPersonaService {
    
    public List<Persona> getPersonas ();
    
    public void savePersona (Persona perso);
    
    public void deletePersona (Long id);
    
    public Persona findPersona (Long id);
}
