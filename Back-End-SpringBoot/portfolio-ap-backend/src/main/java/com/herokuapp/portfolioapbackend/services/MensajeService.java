/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Mensaje;
import com.herokuapp.portfolioapbackend.repository.MensajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */

@Service
public class MensajeService implements IMensajeService{
    
    @Autowired
    private MensajeRepository mensajeRepo;

    @Override
    public List<Mensaje> traer() {
        return mensajeRepo.findAll();
    }

    @Override
    public Mensaje traer(Long id) {
        return mensajeRepo.findById(id).orElse(null);
    }

    @Override
    public Mensaje guardar(Mensaje mensaje) {
        return mensajeRepo.save(mensaje);
    }

    @Override
    public void modificar(Mensaje mensaje) {
        Mensaje guardado=traer(mensaje.getId());
        if(guardado!=null){
            guardado.setTitulo(mensaje.getTitulo());
            guardado.setCuerpo(mensaje.getCuerpo());
            guardado.setFecha(mensaje.getFecha());
            guardado.setLeido(mensaje.isLeido());
            guardado.setAutor(mensaje.getAutor());//Tal vez esto sea innecesario
            mensajeRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        mensajeRepo.deleteById(id);
    }
    
}
