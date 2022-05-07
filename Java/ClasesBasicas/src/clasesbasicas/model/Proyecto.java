/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesbasicas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author carlos
 */
public class Proyecto {
    
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String url;
    private List<ImagenProyecto> imagenes=new ArrayList();

    public Proyecto() {
        
    }
    
    public Proyecto(String nombre, String descripcion, Date fecha, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public void setImagenProyecto(String url, String pie){
        this.imagenes.add(new ImagenProyecto(url,pie));
    }

    public List<ImagenProyecto> getImagenes() {
        return imagenes;
    }
    
    
    
    
    
    
}
