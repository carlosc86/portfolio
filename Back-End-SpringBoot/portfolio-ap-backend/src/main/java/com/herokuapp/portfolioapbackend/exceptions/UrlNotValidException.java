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
public class UrlNotValidException extends Exception {
    
    public static final String DESCRIPCION="La url no tiene el formato correcto";

    public UrlNotValidException() {
        super(DESCRIPCION);
    }

    public UrlNotValidException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
    
}
