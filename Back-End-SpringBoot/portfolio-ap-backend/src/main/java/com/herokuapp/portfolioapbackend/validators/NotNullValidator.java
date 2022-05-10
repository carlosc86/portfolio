/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import com.herokuapp.portfolioapbackend.exceptions.AttributeNullException;

/**
 *
 * @author carlos
 */
public class NotNullValidator extends GenericValidator<Object> {

    @Override
    protected void comprobacion(Object parametro) throws Exception {
        if(parametro==null) throw new AttributeNullException(); 
    }
    
}
