/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import com.herokuapp.portfolioapbackend.exceptions.UrlNotValidException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author carlos
 */
public class UrlFormatValidator extends GenericValidator<String>{
    
    private Pattern pattern = Pattern
				.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$");

    @Override
    protected void comprobacion(String parametro) throws Exception {
        Matcher mather = pattern.matcher(parametro);
        if(!(mather.find()))throw new UrlNotValidException(parametro); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
