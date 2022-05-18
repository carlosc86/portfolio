/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import com.herokuapp.portfolioapbackend.exceptions.NumberOutOfRangeException;

/**
 * Clase usada para validar que un entero este entre dos valores
 * @author carlos
 */
public class IntegerBetweenValidator extends GenericValidator<Integer>{
    
    private int min;
    private int max;
    
    public IntegerBetweenValidator(int min,int max){
        this.min=min;
        this.max=max;
    }

    @Override
    protected void comprobacion(Integer parametro) throws Exception {
        if(parametro>this.max||parametro<this.min) throw new NumberOutOfRangeException("Valor: "+parametro.toString());
    }
    
    
}
