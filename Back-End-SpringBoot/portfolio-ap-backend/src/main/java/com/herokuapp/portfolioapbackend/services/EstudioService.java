/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Estudio;
import com.herokuapp.portfolioapbackend.repository.EstudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class EstudioService implements IEstudioService{
    
    @Autowired
    private EstudioRepository estudioRepo;

    @Override
    public List<Estudio> traer() {
        return estudioRepo.findAll();
    }

    @Override
    public Estudio traer(Long id) {
        return estudioRepo.getById(id);
    }

    @Override
    public Estudio guardar(Estudio estudio) {
        return estudioRepo.save(estudio);
    }

    @Override
    public void modificar(Estudio estudio) {
        Estudio guardado=traer(estudio.getId());
        if(guardado!=null){
            guardado.setTitulo(estudio.getTitulo());
            guardado.setFechaInicio(estudio.getFechaInicio());
            guardado.setFechaFin(estudio.getFechaFin());
            guardado.setInstitucion(estudio.getInstitucion());
            estudioRepo.save(estudio);
        }
        
    }

    @Override
    public void borrar(Long id) {
        estudioRepo.deleteById(id);
    }
    
    
}
