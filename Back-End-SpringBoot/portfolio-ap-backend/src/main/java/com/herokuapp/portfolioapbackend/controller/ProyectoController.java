/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.model.Proyecto;
import com.herokuapp.portfolioapbackend.services.IProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoService;
    
    
    @GetMapping("/proyectos")
    public List<Proyecto> getProyecto(){
        return proyectoService.traer();
    }
    
    @GetMapping("/proyectos/{id}")
    public Proyecto getProyecto(@PathVariable Long id){
        return proyectoService.traer(id);
    }
    
    @PostMapping("/proyectos")
    public Proyecto postProyecto(@RequestBody Proyecto proyecto ){
        return proyectoService.guardar(proyecto);
    }
    
    @PutMapping("/proyectos/{id}")
    public void putProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto ){
        if(id==proyecto.getId())
            proyectoService.modificar(proyecto);
    }
    
    @DeleteMapping("/proyectos/{id}")
    public void deleteProyecto(@PathVariable Long id){
        proyectoService.borrar(id);
    }
    
    
}
