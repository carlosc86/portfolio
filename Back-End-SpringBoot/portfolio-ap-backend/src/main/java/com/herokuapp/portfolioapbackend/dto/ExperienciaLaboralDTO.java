/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.dto;

import com.herokuapp.portfolioapbackend.model.Trabajo;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlos
 */
@Getter @Setter
public class ExperienciaLaboralDTO {
    
    private long id;
    private String puesto;
    private String descripcion;
    private String tipoTrabajo;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String rutaLogoEmpresa;
    private int fechaInicio;
    private int fechaFin;


    public ExperienciaLaboralDTO() {

    }
    
    
    
}
