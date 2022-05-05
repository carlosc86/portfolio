/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.ImagenProyecto;
import com.herokuapp.portfolioapbackend.repository.ImagenProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ImagenProyectoService implements IImagenProyectoService{

    @Autowired
    private ImagenProyectoRepository imagenRepo;
    
    @Override
    public List<ImagenProyecto> traer() {
        return imagenRepo.findAll();
    }

    @Override
    public ImagenProyecto traer(Long id) {
        return imagenRepo.findById(id).orElse(null);
    }

    @Override
    public ImagenProyecto guardar(ImagenProyecto imagen) {
        return imagenRepo.save(imagen);
    }

    @Override
    public void modificar(ImagenProyecto imagen) {
        ImagenProyecto guardada=traer(imagen.getId());
        if(guardada!=null){
            guardada.setUrlImagen(imagen.getUrlImagen());
            guardada.setPieImagen(imagen.getPieImagen().length()>0?
                                    imagen.getPieImagen():
                                    guardada.getPieImagen());
            imagenRepo.save(guardada);
        }
    }

    @Override
    public void borrar(Long id) {
        imagenRepo.deleteById(id);
    }

    @Override
    public List<ImagenProyecto> traerByProyecto(Long idProyecto) {
        return imagenRepo.findByProyectoId(idProyecto);
    }
    
}
