/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

/**
 * Interfaz generica para definir validadores de datos.
 * @author carlos
 */

public interface IGenericValidator<Tipo> {
    
    public void validar(Tipo parametro)throws Exception;
    public void siguiente(IGenericValidator<Tipo> siguiente);
}
