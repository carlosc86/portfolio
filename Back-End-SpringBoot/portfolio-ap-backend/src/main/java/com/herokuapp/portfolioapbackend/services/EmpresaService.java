/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Empresa;
import com.herokuapp.portfolioapbackend.repository.EmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class EmpresaService implements IEmpresaService{
    
    @Autowired
    private EmpresaRepository empresaRepo;

    @Override
    public List<Empresa> traer() {
        return empresaRepo.findAll();
    }

    @Override
    public Empresa traer(Long id) {
        return empresaRepo.findById(id).orElse(null);
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return empresaRepo.save(empresa);
    }

    @Override
    public void modificar(Empresa empresa) {
        Empresa guardada=traer(empresa.getId());
        if(guardada!=null){
            guardada.setNombre(empresa.getNombre());
            guardada.setDireccion(empresa.getDireccion());
            guardada.setRutaLogo(empresa.getRutaLogo());
            empresaRepo.save(guardada);
        }
    }

    @Override
    public void borrar(Long id) {
        empresaRepo.deleteById(id);
    }
    
}
