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
public class MedioContactoNotFoundException extends Exception {
    
    public static final String DESCRIPCION="Medio de contacto no encontrado";

    public MedioContactoNotFoundException() {
        super(DESCRIPCION);
    }

    public MedioContactoNotFoundException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
