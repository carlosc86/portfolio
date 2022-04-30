/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.model.MedioContacto;
import com.herokuapp.portfolioapbackend.services.IMedioContactoService;
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
public class MedioContactoController {
    
    @Autowired
    private  IMedioContactoService medioService;
    
    
    @GetMapping("/medios_contacto")
    public List<MedioContacto> getMediosContacto(){
        return medioService.traer();
    }
    
    @GetMapping("/medios_contacto/{id}")
    public MedioContacto getMedioContacto(@PathVariable Long id){
        return medioService.traer(id);
    }
    
    @PostMapping("/medios_contacto")
    public MedioContacto postMedioContacto(@RequestBody MedioContacto medio ){
        return medioService.guardar(medio);
    }
    
    @PutMapping("/medios_contacto/{id}")
    public void putMedioContacto(@PathVariable Long id, @RequestBody MedioContacto medio ){
        if(id==medio.getId())
            medioService.modificar(medio);
    }
    
    @DeleteMapping("/medios_contacto/{id}")
    public void deleteMedioContacto(@PathVariable Long id){
        medioService.borrar(id);
    }
    
    
}
