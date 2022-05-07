/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.SeccionNotFoundException;
import com.herokuapp.portfolioapbackend.model.Seccion;
import com.herokuapp.portfolioapbackend.repository.SeccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */

@Service
public class SeccionService implements ISeccionService{
    
    @Autowired
    private SeccionRepository seccionRepo;

    @Override
    public List<Seccion> traer() {
        return seccionRepo.findAll();
    }

    @Override
    public Seccion traer(Long id) throws SeccionNotFoundException{
        Seccion seccion=seccionRepo.findById(id).orElse(null);
        if(seccion==null) throw new SeccionNotFoundException("Valor de id: "+id);
        return seccion;
    } 

    @Override
    public Seccion guardar(Seccion seccion) {//Se retorna el objeto guardado
        return seccionRepo.save(seccion);
    }

    @Override
    public void modificar(Seccion seccion)throws SeccionNotFoundException {
        Seccion guardada=traer(seccion.getId());
        if(guardada!=null){//Si existe el elemento
            //Se pueden guardar todos los campos menos el nombre, que es unico, y la relacion con persona.
            guardada.setTitulo(seccion.getTitulo());
            guardada.setTexto(seccion.getTexto());
            guardada.setRutaImagen(seccion.getRutaImagen());
            guardada.setColorFondo(seccion.getColorFondo());
            seccionRepo.save(guardada);
        }
        
    }

    @Override
    public void borrar(Long id) {
        seccionRepo.deleteById(id);
    }

    @Override
    public Seccion traer(String nombre)throws SeccionNotFoundException {
        Seccion seccion=seccionRepo.findByNombre(nombre);
        if(seccion==null)throw new SeccionNotFoundException("Nombre: "+nombre);
        return seccion;
    }
    
}
