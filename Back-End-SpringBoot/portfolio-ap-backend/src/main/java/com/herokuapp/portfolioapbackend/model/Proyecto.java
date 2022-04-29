/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlos
 */
@Getter @Setter
@Entity
@Table(name="Proyectos")
public class Proyecto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String url;
    
    @ManyToOne
    private Usuario persona;
    
    @OneToMany(targetEntity=ImagenProyecto.class, mappedBy="proyecto")
    private List<ImagenProyecto> imagenes=new ArrayList();
    
    //Genero otro setter para las imagenes
    public void setImagen(String url,String pie){
        this.imagenes.add(new ImagenProyecto(url,pie));
    }
}
