/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.TipoMedioContacto;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ITipoMedioContactoService {
    public List<TipoMedioContacto> traer();
    public TipoMedioContacto traer(Long id);
    public void guardar(TipoMedioContacto tipo);
    public void modificar(TipoMedioContacto tipo);
    public void borrar(Long id);
    
}
