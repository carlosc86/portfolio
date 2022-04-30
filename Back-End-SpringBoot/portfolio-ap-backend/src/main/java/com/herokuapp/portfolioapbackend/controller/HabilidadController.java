/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.model.Habilidad;
import com.herokuapp.portfolioapbackend.services.IHabilidadService;
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
public class HabilidadController {
    @Autowired
    private IHabilidadService habilidadService;
    
    
    @GetMapping("/habilidades")
    public List<Habilidad> getHabilidades(){
        return habilidadService.traer();
    }
    
    @GetMapping("/habilidades/{id}")
    public Habilidad getHabilidad(@PathVariable Long id){
        return habilidadService.traer(id);
    }
    
    @PostMapping("/habilidades")
    public Habilidad postHabilidad(@RequestBody Habilidad habilidad ){
        return habilidadService.guardar(habilidad);
    }
    
    @PutMapping("/habilidades/{id}")
    public void putHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidad ){
        if(id==habilidad.getId())
            habilidadService.modificar(habilidad);
    }
    
    @DeleteMapping("/habilidades/{id}")
    public void deleteHabilidad(@PathVariable Long id){
        habilidadService.borrar(id);
    }
    
    
}
