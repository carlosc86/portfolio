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
public class HabilidadNotFoundException extends Exception {
    
    public static final String DESCRIPCION="Habilidad no encontrado";

    public HabilidadNotFoundException() {
        super(DESCRIPCION);
    }

    public HabilidadNotFoundException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
