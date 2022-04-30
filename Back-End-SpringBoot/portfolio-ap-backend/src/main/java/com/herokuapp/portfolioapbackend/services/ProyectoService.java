/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Proyecto;
import com.herokuapp.portfolioapbackend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository proyectoRepo;

    @Override
    public List<Proyecto> traer() {
        return proyectoRepo.findAll();
    }

    @Override
    public Proyecto traer(Long id) {
        return proyectoRepo.findById(id).orElse(null);
    }

    @Override
    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepo.save(proyecto);
    }

    @Override
    public void modificar(Proyecto proyecto) {
        Proyecto guardado=traer(proyecto.getId());
        if(guardado!=null){
            guardado.setNombre(proyecto.getNombre());
            guardado.setDescripcion(proyecto.getDescripcion());
            guardado.setFecha(proyecto.getFecha());
            guardado.setUrl(proyecto.getUrl());
            guardado.setImagenes(proyecto.getImagenes());
            proyectoRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        proyectoRepo.deleteById(id);
    }
    
}
