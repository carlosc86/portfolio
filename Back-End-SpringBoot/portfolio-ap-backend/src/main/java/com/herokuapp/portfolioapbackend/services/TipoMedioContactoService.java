/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.TipoMedioContacto;
import com.herokuapp.portfolioapbackend.repository.TipoMedioContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class TipoMedioContactoService implements ITipoMedioContactoService{

    @Autowired
    private TipoMedioContactoRepository tipoRepo;
    
    @Override
    public List<TipoMedioContacto> traer() {
        return tipoRepo.findAll();
    }

    @Override
    public TipoMedioContacto traer(Long id) {
        return tipoRepo.findById(id).orElse(null);
    }

    @Override
    public TipoMedioContacto guardar(TipoMedioContacto tipo) {
        return tipoRepo.save(tipo);
    }

    @Override
    public void modificar(TipoMedioContacto tipo) {
        TipoMedioContacto guardado=traer(tipo.getId());
        if(guardado!=null){
            guardado.setEmpresa(tipo.getEmpresa());
            guardado.setRutaIcono(tipo.getRutaIcono());
            tipoRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        tipoRepo.deleteById(id);
    }

    @Override
    public TipoMedioContacto traer(String empresa) {
        return tipoRepo.findByEmpresa(empresa);
    }
    
}
