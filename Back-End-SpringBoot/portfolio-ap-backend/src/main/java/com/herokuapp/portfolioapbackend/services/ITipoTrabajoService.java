/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.TipoTrabajo;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ITipoTrabajoService {
    public List<TipoTrabajo> traer();
    public TipoTrabajo traer(Long id);
    public TipoTrabajo guardar(TipoTrabajo tipo);
    public void modificar(TipoTrabajo tipo);
    public void borrar(Long id);
    
}
