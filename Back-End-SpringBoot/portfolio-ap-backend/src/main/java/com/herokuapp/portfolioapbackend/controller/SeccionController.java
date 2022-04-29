/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.model.Seccion;
import com.herokuapp.portfolioapbackend.services.ISeccionService;
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
    public Seccion[] traer(){
        return (Seccion[]) seccionService.traer().toArray();
    }
    
    @PostMapping("/secciones")
    public Seccion guardar(@RequestBody Seccion seccion){
        return seccionService.guardar(seccion);
    }
    
    @PutMapping("/secciones/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody Seccion seccion){
        if(id==seccion.getId())
            seccionService.modificar(seccion);
    }
    
    @DeleteMapping("/secciones/{id}")
    public void borrar(@PathVariable Long id){
        seccionService.borrar(id);
    }
    
}
