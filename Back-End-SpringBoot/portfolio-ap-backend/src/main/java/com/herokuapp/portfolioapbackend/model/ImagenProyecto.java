/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlos
 */
@Getter @Setter
@Entity
@Table(name="ImagenesProyecto")
public class ImagenProyecto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String urlImagen;
    private String pieImagen;
    @ManyToOne
    private Proyecto proyecto;
    
    public ImagenProyecto(String urlImagen, String pieImagen) {
        this.urlImagen = urlImagen;
        this.pieImagen = pieImagen;
    }
    
    
    
}
