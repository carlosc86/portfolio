/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.SeccionDTO;
import com.herokuapp.portfolioapbackend.exceptions.SeccionNotFoundException;
import com.herokuapp.portfolioapbackend.mappers.ISeccionMapper;
import com.herokuapp.portfolioapbackend.model.Seccion;
import com.herokuapp.portfolioapbackend.services.ISeccionService;
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
public class SeccionController {
    
    @Autowired
    private ISeccionMapper seccionMapper;
    
    @Autowired
    private ISeccionService seccionService;
    
    @GetMapping("/secciones")
    public List<SeccionDTO> getSecciones(){
        List<Seccion> lista=seccionService.traer();
        List<SeccionDTO> retorno=new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(seccionMapper.toDTO(lista.get(i)));
        }
        return retorno;
    }
    
    @GetMapping("/secciones/{id}")
    public SeccionDTO getSeccion(@PathVariable Long id)throws Exception{
        return seccionMapper.toDTO(seccionService.traer(id));
    }
    
    @PostMapping("/secciones")
    public SeccionDTO postSeccion(@RequestBody SeccionDTO seccionDto){
        /*Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo*/
        return seccionMapper.toDTO(seccionService.guardar(seccionMapper.toEntity(seccionDto)));
    }
    
    @PutMapping("/secciones/{id}")
    public void putSeccion(@PathVariable Long id, @RequestBody SeccionDTO seccionDto)throws Exception{
        if(id==seccionDto.getId())
            seccionService.modificar(seccionMapper.toEntity(seccionDto));
    }
    
    @DeleteMapping("/secciones/{id}")
    public void deleteSeccion(@PathVariable Long id){
        seccionService.borrar(id);
    }
    
}
