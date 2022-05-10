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
public class EmailNotValidException extends Exception {
    
    public static final String DESCRIPCION="El email no tiene el formato correcto";

    public EmailNotValidException() {
        super(DESCRIPCION);
    }

    public EmailNotValidException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
    
}
