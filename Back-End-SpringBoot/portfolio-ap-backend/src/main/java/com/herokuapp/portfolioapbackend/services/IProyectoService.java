/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Proyecto;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IProyectoService {
    public List<Proyecto> traer();
    public Proyecto traer(Long id);
    public Proyecto guardar(Proyecto proyecto);
    public void modificar(Proyecto proyecto);
    public void borrar(Long id);
    
}
