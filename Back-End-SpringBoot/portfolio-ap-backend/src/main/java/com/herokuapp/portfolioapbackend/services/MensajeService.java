/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.MensajeNotFoundException;
import com.herokuapp.portfolioapbackend.model.Mensaje;
import com.herokuapp.portfolioapbackend.model.Visitante;
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
    @Autowired 
    private VisitanteService visitanteService;

    @Override
    public List<Mensaje> traer() {
        return mensajeRepo.findAll();
    }

    @Override
    public Mensaje traer(Long id)throws MensajeNotFoundException {
        Mensaje mensaje=mensajeRepo.findById(id).orElse(null);
        if(mensaje==null)throw new MensajeNotFoundException("Valor de id: "+id);
        return mensaje;
    }

    @Override
    public Mensaje guardar(Mensaje mensaje) {
        Visitante autor=gestionarVisitante(mensaje.getAutor());
        mensaje.setAutor(autor);
        return mensajeRepo.save(mensaje);
    }

    @Override
    public void modificar(Mensaje mensaje)throws MensajeNotFoundException {
        Mensaje guardado=traer(mensaje.getId());
        Visitante autor=gestionarVisitante(mensaje.getAutor());
        if(guardado!=null){
            guardado.setTitulo(mensaje.getTitulo());
            guardado.setCuerpo(mensaje.getCuerpo());
            guardado.setFecha(mensaje.getFecha());
            guardado.setLeido(mensaje.isLeido());
            guardado.setAutor(autor);
            mensajeRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        mensajeRepo.deleteById(id);
    }

    private Visitante gestionarVisitante(Visitante autor) {
        Visitante visitante=visitanteService.traer(autor.getNombre(),
                                                   autor.getApellido(),
                                                   autor.getEmail());
        if(visitante==null){
            visitante=new Visitante();
            visitante.setNombre(autor.getNombre());
            visitante.setApellido(autor.getApellido());
            visitante.setEmail(autor.getEmail());
            visitante.setId(0L);
            visitante=visitanteService.guardar(visitante);
        }
        
        return visitante;
    }
    
}
