/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.MensajeDTO;
import com.herokuapp.portfolioapbackend.mappers.IMensajeMapper;
import com.herokuapp.portfolioapbackend.model.Mensaje;
import com.herokuapp.portfolioapbackend.services.IMensajeService;
import java.util.ArrayList;
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
    private IMensajeMapper mensajeMapper;
    
    @Autowired
    private IMensajeService mensajeService;
    
    
    @GetMapping("/mensajes")
    public List<MensajeDTO> getMensaje(){
        List<Mensaje> lista= mensajeService.traer();
        List<MensajeDTO> retorno=new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(mensajeMapper.toDTO(lista.get(i)));
        }
        return retorno;
    }
    
    @GetMapping("/mensajes/{id}")
    public MensajeDTO getMensaje(@PathVariable Long id){
        return mensajeMapper.toDTO(mensajeService.traer(id));
    }
    
    @PostMapping("/mensajes")
    public MensajeDTO postMensaje(@RequestBody MensajeDTO mensajeDto ){
        /*Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo*/
        return mensajeMapper.toDTO(mensajeService.guardar(mensajeMapper.toEntity(mensajeDto)));
    }
    
    @PutMapping("/mensajes/{id}")
    public void putMensaje(@PathVariable Long id, @RequestBody MensajeDTO mensajeDto ){
        if(id==mensajeDto.getId())
            mensajeService.modificar(mensajeMapper.toEntity(mensajeDto));
    }
    
    @DeleteMapping("/mensajes/{id}")
    public void deleteMensaje(@PathVariable Long id){
        mensajeService.borrar(id);
    }
    
    
}
