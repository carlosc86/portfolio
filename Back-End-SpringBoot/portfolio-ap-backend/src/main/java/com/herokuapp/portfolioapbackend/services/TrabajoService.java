/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Trabajo;
import com.herokuapp.portfolioapbackend.repository.TrabajoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class TrabajoService implements ITrabajoService{
    
    @Autowired
    private TrabajoRepository trabajoRepo;

    @Override
    public List<Trabajo> traer() {
        return trabajoRepo.findAll();
    }

    @Override
    public Trabajo traer(Long id) {
        return trabajoRepo.getById(id);
    }

    @Override
    public Trabajo guardar(Trabajo trabajo) {
        return trabajoRepo.save(trabajo);
    }

    @Override
    public void modificar(Trabajo trabajo) {
        Trabajo guardado=traer(trabajo.getId());
        if(guardado!=null){
            guardado.setPuesto(trabajo.getPuesto());
            guardado.setDescripcion(trabajo.getDescripcion());
            guardado.setFechaInicio(trabajo.getFechaInicio());
            guardado.setFechaFin(trabajo.getFechaFin());
            guardado.setTipo(trabajo.getTipo());
            guardado.setEmpresa(trabajo.getEmpresa());
            trabajoRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        trabajoRepo.deleteById(id);
    }
    
}
