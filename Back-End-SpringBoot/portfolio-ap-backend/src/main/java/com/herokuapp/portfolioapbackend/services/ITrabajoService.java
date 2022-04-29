/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Trabajo;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ITrabajoService {
    public List<Trabajo> traer();
    public Trabajo traer(Long id);
    public void guardar(Trabajo trabajo);
    public void modificar(Trabajo trabajo);
    public void borrar(Long id);
    
}
