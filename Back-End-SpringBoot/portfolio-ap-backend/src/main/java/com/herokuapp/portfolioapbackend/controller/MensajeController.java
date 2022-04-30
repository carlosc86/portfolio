/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.model.Mensaje;
import com.herokuapp.portfolioapbackend.services.IMensajeService;
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
public class MensajeController {
    @Autowired
    private IMensajeService mensajeService;
    
    
    @GetMapping("/mensajes")
    public List<Mensaje> getMensaje(){
        return mensajeService.traer();
    }
    
    @GetMapping("/mensajes/{id}")
    public Mensaje getMensaje(@PathVariable Long id){
        return mensajeService.traer(id);
    }
    
    @PostMapping("/mensajes")
    public Mensaje postMensaje(@RequestBody Mensaje mensaje ){
        return mensajeService.guardar(mensaje);
    }
    
    @PutMapping("/mensajes/{id}")
    public void putMensaje(@PathVariable Long id, @RequestBody Mensaje mensaje ){
        if(id==mensaje.getId())
            mensajeService.modificar(mensaje);
    }
    
    @DeleteMapping("/mensajes/{id}")
    public void deleteMensaje(@PathVariable Long id){
        mensajeService.borrar(id);
    }
    
    
}
