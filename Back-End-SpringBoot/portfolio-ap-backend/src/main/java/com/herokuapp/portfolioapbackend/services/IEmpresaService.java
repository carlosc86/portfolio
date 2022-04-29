/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Empresa;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IEmpresaService {
    public List<Empresa> traer();
    public Empresa traer(Long id);
    public Empresa guardar(Empresa empresa);
    public void modificar(Empresa empresa);
    public void borrar(Long id);
}
