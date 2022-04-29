/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Privilegio;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IPrivilegioService {
    public List<Privilegio> traer();
    public Privilegio traer(Long id);
    public Privilegio guardar(Privilegio privilegio);
    public void modificar(Privilegio privilegio);
    public void borrar(Long id);
    
}
