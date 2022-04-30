/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.model.Estudio;
import com.herokuapp.portfolioapbackend.services.IEstudioService;
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
public class EstudioController {
    
    @Autowired
    private IEstudioService estudioService;
    
    @GetMapping("/estudios")
    public List<Estudio> getEstudios(){
        return estudioService.traer();
    }
    
    @GetMapping("/estudios/{id}")
    public Estudio getEstudio(@PathVariable Long id){
        return estudioService.traer(id);
    }
    
    @PostMapping("/estudios")
    public Estudio postEstudios(@RequestBody Estudio estudio ){
        return estudioService.guardar(estudio);
    }
    
    @PutMapping("/estudios/{id}")
    public void putEstudios(@PathVariable Long id, @RequestBody Estudio estudio ){
        if(id==estudio.getId())
            estudioService.modificar(estudio);
    }
    
    @DeleteMapping("/estudios/{id}")
    public void deleteEstudio(@PathVariable Long id){
        estudioService.borrar(id);
    }
    
    
}
