/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Institucion;
import com.herokuapp.portfolioapbackend.repository.InstitucionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class InstitucionService implements IInstitucionService{
    @Autowired
    private InstitucionRepository instRepo;

    @Override
    public List<Institucion> traer() {
        return instRepo.findAll();
    }

    @Override
    public Institucion traer(Long id) {
        return instRepo.findById(id).orElse(null);
    }

    @Override
    public Institucion guardar(Institucion institucion) {
        return instRepo.save(institucion);
    }

    @Override
    public void modificar(Institucion institucion) {
        Institucion guardada=traer(institucion.getId());
        if(guardada!=null){
            guardada.setNombre(institucion.getNombre());
            guardada.setDireccion(institucion.getDireccion());
            guardada.setRutaLogo(institucion.getRutaLogo());
            instRepo.save(guardada);
        }
    }

    @Override
    public void borrar(Long id) {
        instRepo.deleteById(id);
    }

    @Override
    public Institucion traer(String nombre) {
        return instRepo.findByNombre(nombre);
    }
    
}
