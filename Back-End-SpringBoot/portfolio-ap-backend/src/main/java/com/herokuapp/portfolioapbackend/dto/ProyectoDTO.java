/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.dto;

import com.herokuapp.portfolioapbackend.model.Proyecto;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlos
 */
@Getter @Setter
public class ProyectoDTO {
    
    private long id;
    private String nombre;
    private String descripcion;
    private int fecha;
    private String link;
    private String[] rutasImagenes;

    public ProyectoDTO() {
    }

    public ProyectoDTO(Proyecto p) {
        this.nombre=p.getNombre();
        this.descripcion=p.getDescripcion();
        this.link=p.getUrl();
        this.fecha=p.getFecha().getYear();
        this.rutasImagenes=new String[p.getImagenes().size()];
        for (int i = 0; i < p.getImagenes().size(); i++) {
            this.rutasImagenes[i]=(p.getImagenes().get(i).getUrlImagen());            
        }        
    }
    
    
}
