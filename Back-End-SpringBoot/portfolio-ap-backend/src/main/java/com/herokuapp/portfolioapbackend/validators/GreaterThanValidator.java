/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import com.herokuapp.portfolioapbackend.exceptions.AttributeNotGreaterException;

/**
 *
 * @author carlos
 */
public class GreaterThanValidator extends GenericValidator<Double>{
    
    private Double referencia;
    
    public GreaterThanValidator(Double referencia){
        this.referencia=referencia;
    }
    /*
    public GreaterThanValidator(long referencia){
        this.referencia=(double)referencia;
    }
    public GreaterThanValidator(int referencia){
        this.referencia=(double)referencia;
    }
    public GreaterThanValidator(float referencia){
        this.referencia=(double)referencia;
    }
    */

    @Override
    protected void comprobacion(Double parametro) throws Exception {
        
        if(parametro<=referencia)throw new AttributeNotGreaterException();
    }
    
}
