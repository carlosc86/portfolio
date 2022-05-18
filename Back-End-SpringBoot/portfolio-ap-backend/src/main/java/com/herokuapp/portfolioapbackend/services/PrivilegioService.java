/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Privilegio;
import com.herokuapp.portfolioapbackend.repository.PrivilegioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class PrivilegioService implements IPrivilegioService {
    
    @Autowired
    private PrivilegioRepository privilegioRepo;

    @Override
    public List<Privilegio> traer() {
        return privilegioRepo.findAll();
    }

    @Override
    public Privilegio traer(Long id) {
        return privilegioRepo.findById(id).orElse(null);
    }

    @Override
    public Privilegio guardar(Privilegio privilegio) {
        return privilegioRepo.save(privilegio);
    }

    @Override
    public void modificar(Privilegio privilegio) {
        Privilegio guardado=traer(privilegio.getId());
        if(guardado!=null){
            guardado.setNombre(privilegio.getNombre());
        }
    }

    @Override
    public void borrar(Long id) {
        privilegioRepo.deleteById(id);
    }

    @Override
    public Privilegio traer(String nombre) {
        return privilegioRepo.findByNombre(nombre);
    }
    
}
