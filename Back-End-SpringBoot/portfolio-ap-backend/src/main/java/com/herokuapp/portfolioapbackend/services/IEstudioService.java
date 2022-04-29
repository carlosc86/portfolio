/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Estudio;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IEstudioService {
    public List<Estudio> traer();
    public Estudio traer(Long id);
    public Estudio guardar(Estudio estudio);
    public void modificar(Estudio estudio);
    public void borrar(Long id);
    
}
