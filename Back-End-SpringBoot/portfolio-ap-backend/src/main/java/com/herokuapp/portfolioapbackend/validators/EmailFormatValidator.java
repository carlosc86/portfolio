/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import com.herokuapp.portfolioapbackend.exceptions.EmailNotValidException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que valida que la direccion de correo electronico este bien formada
 * @author carlos
 */
public class EmailFormatValidator extends GenericValidator<String>{
    
    private Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    protected void comprobacion(String parametro) throws Exception {
        Matcher mather = pattern.matcher(parametro);
        if(!(mather.find()))throw new EmailNotValidException(parametro); //To change body of generated methods, choose Tools | Templates.
    }
    
}
