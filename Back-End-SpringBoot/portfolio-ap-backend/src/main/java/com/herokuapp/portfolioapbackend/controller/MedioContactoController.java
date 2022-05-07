/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.MedioContactoDTO;
import com.herokuapp.portfolioapbackend.mappers.IMedioContactoMapper;
import com.herokuapp.portfolioapbackend.model.MedioContacto;
import com.herokuapp.portfolioapbackend.services.IMedioContactoService;
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
@CrossOrigin(origins="http://localhost:4200")//Por ahora asi para poder usar angular
@RestController
public class MedioContactoController {
    
    @Autowired
    private IMedioContactoMapper medioMapper;
    
    @Autowired
    private  IMedioContactoService medioService;
    
    
    @GetMapping("/medios_contacto")
    public List<MedioContactoDTO> getMediosContacto(){
        List<MedioContacto> lista=medioService.traer();
        List<MedioContactoDTO> retorno=new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(medioMapper.toDTO(lista.get(i)));
        }
        return retorno;
    }
    
    @GetMapping("/medios_contacto/{id}")
    public MedioContactoDTO getMedioContacto(@PathVariable Long id)throws Exception{
        return medioMapper.toDTO(medioService.traer(id));
    }
    
    @PostMapping("/medios_contacto")
    public MedioContactoDTO postMedioContacto(@RequestBody MedioContactoDTO medioDto ){ 
        /*Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo*/
        return medioMapper.toDTO(medioService.guardar(medioMapper.toEntity(medioDto)));
    }
    
    @PutMapping("/medios_contacto/{id}")
    public void putMedioContacto(@PathVariable Long id, @RequestBody MedioContactoDTO medioDto )throws Exception{
        if(id==medioDto.getId())
            medioService.modificar(medioMapper.toEntity(medioDto));
    }
    
    @DeleteMapping("/medios_contacto/{id}")
    public void deleteMedioContacto(@PathVariable Long id){
        medioService.borrar(id);
    }
    
    
}
