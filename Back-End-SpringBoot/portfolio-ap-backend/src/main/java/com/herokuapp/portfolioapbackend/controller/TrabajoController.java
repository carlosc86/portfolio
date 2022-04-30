/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.model.Trabajo;
import com.herokuapp.portfolioapbackend.services.ITrabajoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlos
 */
@RestController
public class TrabajoController {
    
    @Autowired
    private ITrabajoService trabajoService;
    
    
    @GetMapping("/experiencias")
    public List<Trabajo> getTrabajo(){
        return trabajoService.traer();
    }
    
    @GetMapping("/experiencias/{id}")
    public Trabajo getTrabajo(@PathVariable Long id){
        return trabajoService.traer(id);
    }
    
    @PostMapping("/experiencias")
    public Trabajo postTrabajo(@RequestBody Trabajo trabajo ){
        return trabajoService.guardar(trabajo);
    }
    
    @PutMapping("/experiencias/{id}")
    public void putTrabajo(@PathVariable Long id, @RequestBody Trabajo trabajo ){
        if(id==trabajo.getId())
            trabajoService.modificar(trabajo);
    }
    
    @DeleteMapping("/experiencias/{id}")
    public void delete(@PathVariable Long id){
        trabajoService.borrar(id);
    }
    
    
}
