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
public class TokenInvalidException extends Exception {
    
    public static final String DESCRIPCION="El token no tiene el formato valido";

    public TokenInvalidException() {
        super(DESCRIPCION);
    }

    public TokenInvalidException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
