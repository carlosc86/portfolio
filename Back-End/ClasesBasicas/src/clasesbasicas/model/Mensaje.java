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
public class Mensaje {
    
   private String titulo;
   private String cuerpo;
   private Date fecha;
   private boolean leido=false;
   private Visitante autor;

    public Mensaje() {
    }

    public Mensaje(String titulo, String cuerpo, Date fecha, Visitante autor) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
        this.autor = autor;
    }
   
   

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Visitante getAutor() {
        return autor;
    }

    public void setAutor(Visitante autor) {
        this.autor = autor;
    }
   
   
   
    
}
