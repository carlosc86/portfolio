/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.ProyectoNotFoundException;
import com.herokuapp.portfolioapbackend.model.ImagenProyecto;
import com.herokuapp.portfolioapbackend.model.Proyecto;
import com.herokuapp.portfolioapbackend.repository.ProyectoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private IImagenProyectoService imagenService;
    
    @Autowired
    private ProyectoRepository proyectoRepo;

    @Override
    public List<Proyecto> traer() {
        return proyectoRepo.findAll();
    }

    @Override
    public Proyecto traer(Long id)throws ProyectoNotFoundException {
        Proyecto proyecto=proyectoRepo.findById(id).orElse(null);
        if(proyecto==null)throw new ProyectoNotFoundException("Valor de id: "+id);
        return proyecto;
    }

    @Override
    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepo.save(proyecto);
    }

    @Override
    public void modificar(Proyecto proyecto)throws ProyectoNotFoundException {
        Proyecto guardado=traer(proyecto.getId());
        if(guardado!=null){
            guardado.setNombre(proyecto.getNombre());
            guardado.setDescripcion(proyecto.getDescripcion());
            guardado.setFecha(proyecto.getFecha());
            guardado.setUrl(proyecto.getUrl());
            List<ImagenProyecto> imagenesAgregadas=this.getionarImagenes(guardado.getImagenes(),proyecto.getImagenes());
            guardado.setImagenes(imagenesAgregadas);
            proyectoRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        List<ImagenProyecto> imagenes=imagenService.traerByProyecto(id);
        for (int i = 0; i < imagenes.size(); i++) {
            imagenService.borrar(imagenes.get(i).getId());
        }
        proyectoRepo.deleteById(id);
    }

    private List<ImagenProyecto> getionarImagenes(List<ImagenProyecto> guardadas,List<ImagenProyecto> modificadas) {
        List<ImagenProyecto> agregadas=new ArrayList();
        List<ImagenProyecto> quitadas=new ArrayList();
        /*busco rutas de imagenes agregadas*/
        for (int i = 0; i < modificadas.size(); i++) {
            if(!(estaRutaEnLista(modificadas.get(i).getUrlImagen(),guardadas))){
                agregadas.add(modificadas.get(i));
            }
        }
        /*busco rutas de imagenes que se hayan quitado*/
        for (int j = 0; j < guardadas.size(); j++) { 
            if(!(estaRutaEnLista(guardadas.get(j).getUrlImagen(),modificadas))){
                quitadas.add(guardadas.get(j));
            }
        }
        /*Elimino las imagenes que se quitaron*/
        for (int k = 0; k < quitadas.size(); k++) {
            Long idAborrar=quitadas.get(k).getId();
            imagenService.borrar(idAborrar);
        }
        /*devuelvo las rutas de las imagenes agregadas, para que sean guardadas al guardar el proyecto*/
        return agregadas;
    }
    
    private boolean estaRutaEnLista(String ruta,List<ImagenProyecto> lista){
        boolean retorno=false;
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getUrlImagen().equalsIgnoreCase(ruta)){
                retorno=true;
                break;
            }
        }
        //System.out.println(retorno);
        return retorno;
    }
    
}
