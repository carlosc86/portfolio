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
public class AttributeNotGreaterException extends Exception {
    
    public static final String DESCRIPCION="El campo enviado no es mayor";

    public AttributeNotGreaterException() {
        super(DESCRIPCION);
    }

    public AttributeNotGreaterException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
