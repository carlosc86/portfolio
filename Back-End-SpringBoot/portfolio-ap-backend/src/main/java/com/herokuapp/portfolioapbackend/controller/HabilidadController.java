/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.HabilidadDTO;
import com.herokuapp.portfolioapbackend.mappers.IHabilidadMapper;
import com.herokuapp.portfolioapbackend.model.Habilidad;
import com.herokuapp.portfolioapbackend.services.IHabilidadService;
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
public class HabilidadController {
    
    @Autowired
    private IHabilidadMapper habilidadMapper;
    
    @Autowired
    private IHabilidadService habilidadService;
    
    
    @GetMapping("/habilidades")
    public List<HabilidadDTO> getHabilidades()throws Exception{
        List<Habilidad> habilidades= habilidadService.traer();
        List<HabilidadDTO> retorno=new ArrayList();
        for (int i = 0; i < habilidades.size(); i++) {
            retorno.add(habilidadMapper.toDTO(habilidades.get(i)));
        }
        return retorno;
    }
    
    @GetMapping("/habilidades/{id}")
    public HabilidadDTO getHabilidad(@PathVariable Long id)throws Exception{
        return habilidadMapper.toDTO(habilidadService.traer(id));
    }
    
    @PostMapping("/habilidades")
    public HabilidadDTO postHabilidad(@RequestBody HabilidadDTO habilidadDto )throws Exception{
        /*Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo*/
        return habilidadMapper.toDTO(habilidadService.guardar(habilidadMapper.toEntity(habilidadDto)));
    }
    
    @PutMapping("/habilidades/{id}")
    public void putHabilidad(@PathVariable Long id, @RequestBody HabilidadDTO habilidadDto )throws Exception{
        if(id==habilidadDto.getId())
            habilidadService.modificar(habilidadMapper.toEntity(habilidadDto));
    }
    
    @DeleteMapping("/habilidades/{id}")
    public void deleteHabilidad(@PathVariable Long id){
        habilidadService.borrar(id);
    }
    
    
}
