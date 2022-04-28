/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesbasicas.model;

import java.util.Date;

/**
 *
 * @author carlos
 */
public class Trabajo {
    
    private String puesto;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private Empresa empresa;
    private TipoTrabajo tipo;

    public Trabajo() {
    }

    public Trabajo(String puesto, String descripcion, Date fechaInicio, Date fechaFin, Empresa empresa, TipoTrabajo tipo) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empresa = empresa;
        this.tipo = tipo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoTrabajo getTipo() {
        return tipo;
    }

    public void setTipo(TipoTrabajo tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
