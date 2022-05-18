/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import com.herokuapp.portfolioapbackend.exceptions.NotPastDateException;
import java.time.LocalDate;

/**
 * Comprueba que una fecha sea anterior a la actual
 * @author carlos
 */
public class PastValidator extends GenericValidator<LocalDate>{

    @Override
    protected void comprobacion(LocalDate parametro) throws Exception {
        if(parametro.isAfter(LocalDate.now()))throw new NotPastDateException(parametro.toString());
    }
    
}
