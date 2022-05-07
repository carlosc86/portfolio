/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.exceptions;

/**
 *
 * @author carlos
 */
class ErrorMessage {
    
    private String excepcion;
    private String mensaje;
    private String ruta;

    ErrorMessage(Exception exception, String path) {
        this(exception.getClass().getSimpleName(),exception.getMessage(),path);
    }

    public ErrorMessage(String excepcion, String mensaje, String ruta) {
        this.excepcion = excepcion;
        this.mensaje = mensaje;
        this.ruta = ruta;
    }
    
    public String getException(){
        return this.excepcion;
    }
    public String getMessage(){
        return this.mensaje;
    }
    public String getPath(){
        return ruta;
    }
    
    @Override
    public String toString(){
        return "ErrorMessage [exception: "+this.excepcion+", message: "+this.mensaje+", path: "+this.ruta+"]";
    }
    
}
