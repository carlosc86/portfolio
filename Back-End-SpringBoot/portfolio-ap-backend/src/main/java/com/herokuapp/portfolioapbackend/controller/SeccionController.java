/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.SeccionDTO;
import com.herokuapp.portfolioapbackend.mappers.ISeccionMapper;
import com.herokuapp.portfolioapbackend.model.Seccion;
import com.herokuapp.portfolioapbackend.services.ISeccionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins="${portfolio.frontend.url}")//Por ahora asi para poder usar angular
@RestController
public class SeccionController {
    
    @Autowired
    private ISeccionMapper seccionMapper;
    
    @Autowired
    private ISeccionService seccionService;
    
    /*Endpoint para obtener todas las secciones cargadas en la db*/
    @GetMapping("/secciones")
    public List<SeccionDTO> getSecciones()throws Exception{
        List<Seccion> lista=seccionService.traer();
        List<SeccionDTO> retorno=new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(seccionMapper.toDTO(lista.get(i)));
        }
        return retorno;
    }
    
    /*Endpoint para obtener una seccion en particular, especificada por el campo id*/
    @GetMapping("/secciones/{id}")
    public SeccionDTO getSeccion(@PathVariable Long id)throws Exception{
        return seccionMapper.toDTO(seccionService.traer(id));
    }
    
    /*Endpoint para cargar una nueva seccion*/
    @PostMapping("/secciones")
    public SeccionDTO postSeccion(@RequestBody SeccionDTO seccionDto)throws Exception{
        /*Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo*/
        return seccionMapper.toDTO(seccionService.guardar(seccionMapper.toEntity(seccionDto)));
    }
    
    /*Endpoint para modificar una seccion existente, especificada por el campo id*/
    @PutMapping("/secciones/{id}")
    public void putSeccion(@PathVariable Long id, @RequestBody SeccionDTO seccionDto)throws Exception{
        if(id==seccionDto.getId())
            seccionService.modificar(seccionMapper.toEntity(seccionDto));
    }
    
    /*Endpoint para eliminar una seccion existente*/
    @DeleteMapping("/secciones/{id}")
    public void deleteSeccion(@PathVariable Long id){
        seccionService.borrar(id);
    }
    
}
