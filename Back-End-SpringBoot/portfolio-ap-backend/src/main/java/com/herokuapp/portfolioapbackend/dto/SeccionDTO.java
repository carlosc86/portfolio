/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlos
 */
@Getter @Setter
public class SeccionDTO implements Serializable{
    
    private long id;
    
    private String nombre;
    private String titulo;
    private String texto;
    private String rutaImagen;
    private String colorFondo; 
    private String colorTexto;

    public SeccionDTO() {
    }
    
    
    
}
