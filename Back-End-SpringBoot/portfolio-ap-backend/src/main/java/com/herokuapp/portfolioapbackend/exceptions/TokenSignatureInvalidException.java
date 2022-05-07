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
public class TokenSignatureInvalidException extends Exception {
    
    public static final String DESCRIPCION="La firma del token es invalida";

    public TokenSignatureInvalidException() {
        super(DESCRIPCION);
    }

    public TokenSignatureInvalidException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
