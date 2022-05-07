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
public class TokenTimeExpiredException extends Exception {
    
    public static final String DESCRIPCION="El token de seguridad ya caducó";

    public TokenTimeExpiredException() {
        super(DESCRIPCION);
    }

    public TokenTimeExpiredException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
