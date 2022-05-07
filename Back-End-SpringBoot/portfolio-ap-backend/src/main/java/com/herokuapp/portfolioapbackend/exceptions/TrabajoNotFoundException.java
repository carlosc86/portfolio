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
public class TrabajoNotFoundException extends Exception {
    
    public static final String DESCRIPCION="Trabajo no encontrado";

    public TrabajoNotFoundException() {
        super(DESCRIPCION);
    }

    public TrabajoNotFoundException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
