/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Visitante;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IVisitanteService {
    public List<Visitante> traer();
    public Visitante traer(Long id);
    public Visitante traer(String nombre, String apellido, String email);
    public Visitante guardar(Visitante visitante);
    public void modificar(Visitante visitante);
    public void borrar(Long id);
    
}
