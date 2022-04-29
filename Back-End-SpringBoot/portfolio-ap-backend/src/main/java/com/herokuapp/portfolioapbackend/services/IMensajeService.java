/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Mensaje;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IMensajeService {
    public List<Mensaje> traer();
    public Mensaje traer(Long id);
    public void guardar(Mensaje mensaje);
    public void modificar(Mensaje mensaje);
    public void borrar(Long id);
    
}
