/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.ExperienciaLaboralDTO;
import com.herokuapp.portfolioapbackend.mappers.IExperienciaLaboralMapper;
import com.herokuapp.portfolioapbackend.model.Trabajo;
import com.herokuapp.portfolioapbackend.services.ITrabajoService;
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
public class TrabajoController {
    
    @Autowired
    private IExperienciaLaboralMapper experienciaMapper;
    
    @Autowired
    private ITrabajoService trabajoService;
    
    /*Enpoint para obtener todas las experiencias laborales cargadas en la db*/
    @GetMapping("/experiencias")
    public List<ExperienciaLaboralDTO> getTrabajo()throws Exception{
        List<Trabajo> lista= trabajoService.traer();
        List<ExperienciaLaboralDTO> retorno=new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(experienciaMapper.toDTO(lista.get(i)));
        }
        return retorno;
    }
    
    /*Endpoint para obtener una experiencia laboral en particular*/
    @GetMapping("/experiencias/{id}")
    public ExperienciaLaboralDTO getTrabajo(@PathVariable Long id)throws Exception{
        return experienciaMapper.toDTO(trabajoService.traer(id));
    }
    
    /*Enpoint para cargar una nueva experiencia laboral*/
    @PostMapping("/experiencias")
    public ExperienciaLaboralDTO postTrabajo(@RequestBody ExperienciaLaboralDTO experiencia )throws Exception{
        /*Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo*/
        return experienciaMapper.toDTO(trabajoService.guardar(experienciaMapper.toEntity(experiencia)));
    }
    
    /*Endpoint para modificar una experiencia laboral, especificada por el id*/
    @PutMapping("/experiencias/{id}")
    public void putTrabajo(@PathVariable Long id, @RequestBody ExperienciaLaboralDTO experiencia )throws Exception{
        if(id==experiencia.getId()){
            trabajoService.modificar(experienciaMapper.toEntity(experiencia));
        }else throw new Exception("La informacion de id suministrada no coincide.");
    }
    
    /*Endpoint para borrar una experiencia laboral en particular*/
    @DeleteMapping("/experiencias/{id}")
    public void delete(@PathVariable Long id){
        trabajoService.borrar(id);
    }
    
    
}
