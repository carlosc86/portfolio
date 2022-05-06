/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.MedioContactoNotFoundException;
import com.herokuapp.portfolioapbackend.model.MedioContacto;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IMedioContactoService {
    public List<MedioContacto> traer();
    public MedioContacto traer(Long id)throws MedioContactoNotFoundException;
    public MedioContacto guardar(MedioContacto medio);
    public void modificar(MedioContacto medio)throws MedioContactoNotFoundException;
    public void borrar(Long id);
    
}
