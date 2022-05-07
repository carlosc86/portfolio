/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author carlos
 */
@Getter @Setter
@Entity
@Table(name="Trabajos")
public class Trabajo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String puesto;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    @ManyToOne
    @JoinColumn(name="tipo_id")
    private TipoTrabajo tipo;
    
    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;
    
    @ManyToOne
    private Usuario persona;
    
}
