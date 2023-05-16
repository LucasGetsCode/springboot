/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yoprogramo.backend.service;

import com.yoprogramo.backend.model.Model;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Home
 */
@Service
public interface IModelService {
    
    public List<Model> getDatos ();
    
    public void savePost (Model perso);
    
    public void deletePost (Long id);
    
    public Model findPost (Long id);
}
