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
public class EstudioNotFoundException extends Exception {
    
    public static final String DESCRIPCION="Estudio no encontrado";

    public EstudioNotFoundException() {
        super(DESCRIPCION);
    }

    public EstudioNotFoundException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
    
    
    
    
}
