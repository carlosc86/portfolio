/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Institucion;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IInstitucionService {
    public List<Institucion> traer();
    public Institucion traer(Long id);
    public void guardar(Institucion institucion);
    public void modificar(Institucion institucion);
    public void borrar(Long id);
    
}
