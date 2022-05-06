/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
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
   
    private String fechaInicio;
    private String fechaFin;

    public EstudioDTO() {
    }    
    
}
