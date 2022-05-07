/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.SeccionNotFoundException;
import com.herokuapp.portfolioapbackend.model.Seccion;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ISeccionService {
    public List<Seccion> traer();
    public Seccion traer(Long id)throws SeccionNotFoundException;
    public Seccion traer(String nombre)throws SeccionNotFoundException;
    public Seccion guardar(Seccion seccion);
    public void modificar(Seccion seccion)throws SeccionNotFoundException;
    public void borrar(Long id);
    
}
