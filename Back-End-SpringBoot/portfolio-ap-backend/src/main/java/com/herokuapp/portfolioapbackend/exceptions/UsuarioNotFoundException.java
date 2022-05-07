/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.exceptions;

/**
 *
 * @author carlos
 */
public class UsuarioNotFoundException extends Exception {
    
    public static final String DESCRIPCION="Usuario no encontrado";

    public UsuarioNotFoundException() {
        super(DESCRIPCION);
    }

    public UsuarioNotFoundException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
