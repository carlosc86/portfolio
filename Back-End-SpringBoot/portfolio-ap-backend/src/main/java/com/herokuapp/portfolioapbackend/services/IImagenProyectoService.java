/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.ImagenProyecto;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IImagenProyectoService {
    public List<ImagenProyecto> traer();
    public ImagenProyecto traer(Long id);
    public void guardar(ImagenProyecto imagen);
    public void modificar(ImagenProyecto imagen);
    public void borrar(Long id);
    
}
