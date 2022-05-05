/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.dto;

import com.herokuapp.portfolioapbackend.model.MedioContacto;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlos
 */
@Getter @Setter
public class MedioContactoDTO {
    
    private long id;
    private String link;
    private String rutaIcono;
   // private String empresa;

    public MedioContactoDTO() {
    }
    
    public MedioContactoDTO(MedioContacto m) {
        this.id=m.getId();
        this.link=m.getLink();
        this.rutaIcono=m.getTipo().getRutaIcono();
    }
    
    
}
