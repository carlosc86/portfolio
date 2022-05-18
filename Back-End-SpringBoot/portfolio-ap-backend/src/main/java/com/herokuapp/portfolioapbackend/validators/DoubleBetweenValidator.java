/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import com.herokuapp.portfolioapbackend.exceptions.NumberOutOfRangeException;

/**
 * Clase que valida si un tipo de dato double esta entre dos valores
 * @author carlos
 */
public class DoubleBetweenValidator extends GenericValidator<Double>{
    
    private Double min;
    private Double max;
    
    public DoubleBetweenValidator(Double min,Double max){
        this.min=min;
        this.max=max;
    }

    @Override
    protected void comprobacion(Double parametro) throws Exception {
        if(parametro>this.max||parametro<this.min) throw new NumberOutOfRangeException("Valor: "+parametro.toString());
    }
    
}
