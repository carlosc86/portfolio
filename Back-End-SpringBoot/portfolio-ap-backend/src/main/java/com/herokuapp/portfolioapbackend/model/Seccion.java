/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.model;

import java.util.List;
import javax.persistence.Column;
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
@Table(name="Secciones")
public class Seccion {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column(unique=true)
    private String nombre;//Nombre es un atributo unico
    private String titulo;
    private String texto;
    @Column(name="urlImagen")
    private String rutaImagen;
    private String colorFondo;
    
    /*Relaciones con los diferentes items. Por ahora no se utlizará
    private List<Estudio> estudios;
    private List<Habilidad> habilidades;
    private List<Trabajo> experiencias_laborales;
    private List<Proyecto> proyectos;
    */
    @ManyToOne
    private Usuario persona;//Para una futura funcionalidad, lo vinculamos con el usuario.
    
    
}
