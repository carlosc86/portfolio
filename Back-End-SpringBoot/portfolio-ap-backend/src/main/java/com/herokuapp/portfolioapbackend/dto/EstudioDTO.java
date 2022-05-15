/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.dto;


import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlos
 */
@Getter @Setter
public class EstudioDTO {
    
    
    private long id;
    private String titulo;
    private String nombreInstitucion;
    private String direccionInstitucion;
    
    private String rutaLogoInstitucion;
    //@NotNull
    private String fechaInicio;
    //@NotNull(message="Error al validar fecha finalizacion")
    private String fechaFin;

    public EstudioDTO() {
    }    
    
}
