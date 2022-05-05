/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Visitante;
import com.herokuapp.portfolioapbackend.repository.VisitanteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class VisitanteService implements IVisitanteService{
    
    @Autowired
    private VisitanteRepository visitanteRepo;

    @Override
    public List<Visitante> traer() {
        return visitanteRepo.findAll();
    }

    @Override
    public Visitante traer(Long id) {
        return visitanteRepo.findById(id).orElse(null);
    }

    @Override
    public Visitante guardar(Visitante visitante) {
        return visitanteRepo.save(visitante);
    }

    @Override
    public void modificar(Visitante visitante) {
        Visitante guardado=traer(visitante.getId());
        if(guardado!=null){
            guardado.setNombre(visitante.getNombre());
            guardado.setApellido(visitante.getApellido());
            guardado.setEmail(visitante.getEmail());
            guardado.setFechaNacimiento(visitante.getFechaNacimiento());
            visitanteRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        visitanteRepo.deleteById(id);
    }

    @Override
    public Visitante traer(String nombre, String apellido, String email) {
        return visitanteRepo.findByNombreApellidoAndEmail(nombre, apellido, email);
    }
    
}
