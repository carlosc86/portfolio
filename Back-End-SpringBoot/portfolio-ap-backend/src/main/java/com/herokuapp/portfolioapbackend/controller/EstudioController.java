/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.EstudioDTO;
import com.herokuapp.portfolioapbackend.mappers.IEstudioMapper;
import com.herokuapp.portfolioapbackend.model.Estudio;
import com.herokuapp.portfolioapbackend.services.IEstudioService;
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
//@PreAuthorize("authenticated")
@CrossOrigin(origins="${portfolio.frontend.url}")//Por ahora asi para poder usar angular
@RestController   
public class EstudioController {
    
    @Autowired
    private IEstudioService estudioService;
    
    @Autowired
    private IEstudioMapper estudioMapper;
    
    
    @GetMapping("/estudios")
    public List<EstudioDTO> getEstudios()throws Exception{
        List<EstudioDTO> retorno=new ArrayList();
        List<Estudio> lista=estudioService.traer();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(estudioMapper.toDTO(lista.get(i)));
        }
        return retorno;
    }
    
    @GetMapping("/estudios/{id}")
    public EstudioDTO getEstudio(@PathVariable Long id)throws Exception{
        return estudioMapper.toDTO(estudioService.traer(id));
    }
    
    @PostMapping("/estudios")
    public EstudioDTO postEstudios(@RequestBody EstudioDTO estudioDTO )throws Exception{
        /*Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo*/
        return estudioMapper.toDTO(estudioService.guardar(estudioMapper.toEntity(estudioDTO)));
    }
    
    @PutMapping("/estudios/{id}")
    public void putEstudios(@PathVariable Long id,@RequestBody EstudioDTO estudioDto )throws Exception{
        if(id==estudioDto.getId())
            estudioService.modificar(estudioMapper.toEntity(estudioDto));
    }
    
    @DeleteMapping("/estudios/{id}")
    public void deleteEstudio(@PathVariable Long id){
        estudioService.borrar(id);
    }
    
    
}
