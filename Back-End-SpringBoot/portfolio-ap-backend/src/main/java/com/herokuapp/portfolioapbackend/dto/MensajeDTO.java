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
public class MensajeDTO {
    
    public Long id;
    public String titulo;
    public String cuerpo;
    public String fecha;
    public Boolean leido;
    public String nombreAutor;
    public String apellidoAutor;
    public String emailAutor;

    public MensajeDTO() {
    }
    
    
}
