/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.HabilidadNotFoundException;
import com.herokuapp.portfolioapbackend.model.Habilidad;
import com.herokuapp.portfolioapbackend.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class HabilidadService implements IHabilidadService{
    
    @Autowired
    private HabilidadRepository habilidadRepo;

    @Override
    public List<Habilidad> traer() {
        return habilidadRepo.findAll();
    }

    @Override
    public Habilidad traer(Long id) throws HabilidadNotFoundException{
        Habilidad habilidad=habilidadRepo.findById(id).orElse(null);
        if(habilidad==null)throw new HabilidadNotFoundException("Valor de id: "+id);
        return habilidad;
    }

    @Override
    public Habilidad guardar(Habilidad habilidad) {
        return habilidadRepo.save(habilidad);
    }

    @Override
    public void modificar(Habilidad habilidad)throws HabilidadNotFoundException {
        Habilidad guardada=traer(habilidad.getId());
        if(guardada!=null){
            guardada.setNombre(habilidad.getNombre());
            guardada.setDescripcion(habilidad.getDescripcion());
            guardada.setPorcentaje(habilidad.getPorcentaje());
            habilidadRepo.save(guardada);
        }
    }

    @Override
    public void borrar(Long id) {
        habilidadRepo.deleteById(id);
    }
    
}
