/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import com.herokuapp.portfolioapbackend.exceptions.NotPastDateException;
import java.time.LocalDate;

/**
 *
 * @author carlos
 */
public class PastThanValidator extends GenericValidator<LocalDate> {
    private LocalDate referencia;
    
    public PastThanValidator(LocalDate referencia){
        this.referencia=referencia;
    }

    @Override
    protected void comprobacion(LocalDate parametro) throws Exception {
        if(parametro.isAfter(referencia))throw new NotPastDateException(parametro.toString()+"->"+referencia.toString());
    }
    
}
