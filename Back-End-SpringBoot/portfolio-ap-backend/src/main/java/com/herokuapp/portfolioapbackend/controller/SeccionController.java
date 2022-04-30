/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.model.Seccion;
import com.herokuapp.portfolioapbackend.services.ISeccionService;
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
public class SeccionController {
    
    @Autowired
    private ISeccionService seccionService;
    
    @GetMapping("/secciones")
    public List<Seccion> getSecciones(){
        return seccionService.traer();
    }
    
    @GetMapping("/secciones/{id}")
    public Seccion getSeccion(@PathVariable Long id){
        return seccionService.traer(id);
    }
    
    @PostMapping("/secciones")
    public Seccion postSeccion(@RequestBody Seccion seccion){
        return seccionService.guardar(seccion);
    }
    
    @PutMapping("/secciones/{id}")
    public void putSeccion(@PathVariable Long id, @RequestBody Seccion seccion){
        if(id==seccion.getId())
            seccionService.modificar(seccion);
    }
    
    @DeleteMapping("/secciones/{id}")
    public void deleteSeccion(@PathVariable Long id){
        seccionService.borrar(id);
    }
    
}
