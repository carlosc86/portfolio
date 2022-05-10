/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

/**
 * Clase abstracta para definir validadores de datos, parte de la cadena de
 * responsabilidades para validar datos.
 * @author carlos
 */
public abstract class GenericValidator<Tipo> implements IGenericValidator<Tipo>{
    
    private IGenericValidator<Tipo> siguiente;
    
    public void siguiente(IGenericValidator<Tipo> siguiente){
        this.siguiente=siguiente;
    }
    
    public void validar(Tipo parametro)throws Exception{
        
        if(siguiente!=null){
            siguiente.validar(parametro);
        }
        comprobacion(parametro);
    }
    
    protected abstract void comprobacion(Tipo parametro) throws Exception;
}
