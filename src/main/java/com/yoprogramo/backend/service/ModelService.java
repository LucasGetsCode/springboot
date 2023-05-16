/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yoprogramo.backend.service;

import com.yoprogramo.backend.repository.ModelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yoprogramo.backend.model.Model;
/**
 *
 * @author Home
 */
@Service
public class ModelService implements IModelService {
    
    @Autowired
    private ModelRepository modelRepo;
    
    @Override
    public List<Model> getDatos() {
        List<Model> listaDatos = modelRepo.findAll();
        return listaDatos;
    }
    
    @Override
    public void savePost(Model model) {
        modelRepo.save(model);
    }
    
    @Override
    public void deletePost(Long id) {
        modelRepo.deleteById(id);              
    }
    
    @Override
    public Model findPost(Long id) {
        Model perso = modelRepo.findById(id).orElse(null);
        return perso;
    }
}
