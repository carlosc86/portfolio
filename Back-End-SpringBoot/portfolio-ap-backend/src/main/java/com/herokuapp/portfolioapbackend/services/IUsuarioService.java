/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Usuario;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IUsuarioService {
    public List<Usuario> traer();
    public Usuario traer(Long id);
    public Usuario traer(String nombreUsuario);
    public void guardar(Usuario usuario);
    public void modificar(Usuario usuario);
    public void borrar(Long id);
    
}
