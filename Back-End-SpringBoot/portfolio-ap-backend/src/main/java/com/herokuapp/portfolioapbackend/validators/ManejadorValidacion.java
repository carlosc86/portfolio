/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.validators;

import java.time.LocalDate;

/**
 * Fachada para los validadores de datos, para validar los datos que ingresan al backend
 * Con esta clase se forman las cadenas de responsabilidades para validar los datos.
 * @author carlos
 */
public class ManejadorValidacion {
    
    private IGenericValidator cadena;
    
    private void agregarEslabon(IGenericValidator eslabon){
        if(cadena!=null){
           eslabon.siguiente(this.cadena);
        }
        this.cadena=eslabon;
    }
    
    /*Con este metodo deben terminar todas las validaciones que se hagan.
    * Como parametro se debe pasar el objeto a validar.
    */
    public void validar(Object aValidar) throws Exception{
        cadena.validar(aValidar);
    }
    
    /*Con este metodo deben empezar todas las validaciones que se hagan*/
    public ManejadorValidacion nueva(){
        this.cadena=null;
        return this;
    }
    
    public ManejadorValidacion noNulo(){
        NotNullValidator validacion=new NotNullValidator();
        this.agregarEslabon(validacion);
        return this;
    }
    
    public ManejadorValidacion mayorQue(Double valor){
        GreaterThanValidator validacion=new GreaterThanValidator(valor);
        this.agregarEslabon(validacion);
        return this;
    }
    
    public ManejadorValidacion pasado(){
        PastValidator validacion=new PastValidator();
        this.agregarEslabon(validacion);
        return this;
    }
    
    public ManejadorValidacion pasadoDe(LocalDate fecha){
        PastThanValidator validacion=new PastThanValidator(fecha);
        this.agregarEslabon(validacion);
        return this;
    }
    
    public ManejadorValidacion cadenaNoVacia(){
        StringNotEmptyValidator validacion=new StringNotEmptyValidator();
        this.agregarEslabon(validacion);
        return this;
    }
    
    public ManejadorValidacion valorDoubleEntre(Double minimo, Double maximo){
        DoubleBetweenValidator validacion=new DoubleBetweenValidator(minimo, maximo);
        this.agregarEslabon(validacion);
        return this;
    }
    public ManejadorValidacion valorEnteroEntre(int minimo, int maximo){
        IntegerBetweenValidator validacion=new IntegerBetweenValidator(minimo, maximo);
        this.agregarEslabon(validacion);
        return this;
    }
    
    public ManejadorValidacion email(){
        EmailFormatValidator validacion=new EmailFormatValidator();
        this.agregarEslabon(validacion);
        return this;
    }
    
    public ManejadorValidacion url(){
        UrlFormatValidator validacion=new UrlFormatValidator();
        this.agregarEslabon(validacion);
        return this;
    }
    
}
