/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.TipoTrabajo;
import com.herokuapp.portfolioapbackend.repository.TipoTrabajoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class TipoTrabajoService implements ITipoTrabajoService{
    @Autowired
    private TipoTrabajoRepository tipoRepo;

    @Override
    public List<TipoTrabajo> traer() {
        return tipoRepo.findAll();
    }

    @Override
    public TipoTrabajo traer(Long id) {
        return tipoRepo.findById(id).orElse(null);
    }

    @Override
    public TipoTrabajo traer(String nombre) {
        return tipoRepo.findByNombre(nombre);
    }

    @Override
    public TipoTrabajo guardar(TipoTrabajo tipo) {
        return tipoRepo.save(tipo);
    }

    @Override
    public void modificar(TipoTrabajo tipo) {
        TipoTrabajo guardado=traer(tipo.getId());
        if(guardado!=null){
            guardado.setNombre(tipo.getNombre());
            tipoRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        tipoRepo.deleteById(id);
    }
    
}
