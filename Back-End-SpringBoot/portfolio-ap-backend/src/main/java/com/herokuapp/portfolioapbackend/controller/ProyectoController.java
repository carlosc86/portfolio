/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.ProyectoDTO;
import com.herokuapp.portfolioapbackend.mappers.IProyectoMapper;
import com.herokuapp.portfolioapbackend.model.Proyecto;
import com.herokuapp.portfolioapbackend.services.IProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoMapper proyectoMapper;
    
    @Autowired
    private IProyectoService proyectoService;
    
    /*Endpoint para obtener todos los poryectos guardados en la db*/
    @GetMapping("/proyectos")
    public List<ProyectoDTO> getProyecto()throws Exception{
        List<Proyecto> lista=proyectoService.traer();
        List<ProyectoDTO> retorno=new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(proyectoMapper.toDTO(lista.get(i)));
        }
        return retorno;
    }
    
    /*Endpoint para obtener un proyecto especifico, identificado por el campo id*/
    @GetMapping("/proyectos/{id}")
    public ProyectoDTO getProyecto(@PathVariable Long id)throws Exception{
        return proyectoMapper.toDTO(proyectoService.traer(id));
    }
    
    /*Endpoint para cargar un nuevo proyecto*/
    @PostMapping("/proyectos")
    public ProyectoDTO postProyecto(@RequestBody ProyectoDTO proyectoDto )throws Exception{
        /*Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo*/
        return proyectoMapper.toDTO(proyectoService.guardar(proyectoMapper.toEntity(proyectoDto)));
    }
    
    /*Endpoint para modificar un proyecto existente, identificado por el campo id*/
    @PutMapping("/proyectos/{id}")
    public void putProyecto(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDto )throws Exception{
        if(id==proyectoDto.getId())
            proyectoService.modificar(proyectoMapper.toEntity(proyectoDto));
    }
    
    /*Endpoint para borrar un proeycto existente, especificado por el campo id*/
    @DeleteMapping("/proyectos/{id}")
    public void deleteProyecto(@PathVariable Long id){
        proyectoService.borrar(id);
    }
    
    
}
