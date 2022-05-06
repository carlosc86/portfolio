/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.exceptions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author carlos
 */
@ControllerAdvice
public class ApiExceptionHandler {
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EstudioNotFoundException.class, HabilidadNotFoundException.class,
                       MedioContactoNotFoundException.class, MensajeNotFoundException.class,
                       ProyectoNotFoundException.class, SeccionNotFoundException.class,
                       TrabajoNotFoundException.class, UsuarioNotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request,Exception exception){
        return new ErrorMessage(exception,request.getRequestURI());
    }
    
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request,Exception exception){
        return new ErrorMessage(exception,request.getRequestURI());
    }
}
