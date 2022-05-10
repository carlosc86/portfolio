/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import com.herokuapp.portfolioapbackend.exceptions.StringEmptyException;

/**
 *
 * @author carlos
 */
public class StringNotEmptyValidator extends GenericValidator<String>{

    @Override
    protected void comprobacion(String parametro) throws Exception {
        if(parametro.isEmpty())throw new StringEmptyException();
    }
    
}
