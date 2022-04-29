/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.MedioContacto;
import com.herokuapp.portfolioapbackend.repository.MedioContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class MedioContactoService implements IMedioContactoService{
    @Autowired
    private MedioContactoRepository medioRepo;

    @Override
    public List<MedioContacto> traer() {
        return medioRepo.findAll();
    }

    @Override
    public MedioContacto traer(Long id) {
        return medioRepo.getById(id);
    }

    @Override
    public MedioContacto guardar(MedioContacto medio) {
        return medioRepo.save(medio);
    }

    @Override
    public void modificar(MedioContacto medio) {
        MedioContacto guardado=traer(medio.getId());
        if(guardado!=null){
            guardado.setLink(medio.getLink());
            guardado.setTipo(medio.getTipo());
            medioRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        medioRepo.deleteById(id);
    }
    
}
