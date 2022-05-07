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
public class SeccionNotFoundException extends Exception {
    
    public static final String DESCRIPCION="Seccion no encontrado";

    public SeccionNotFoundException() {
        super(DESCRIPCION);
    }

    public SeccionNotFoundException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
