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
public class HabilidadDTO {
    
    private long id;
    private String nombre;
    private String descripcion;
    private int porcentaje;

    public HabilidadDTO() {
    }   
    
}
