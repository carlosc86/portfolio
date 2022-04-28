/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesbasicas.model;

import java.util.List;

/**
 *
 * @author carlos
 */
public class Seccion {
    
    private String nombre;
    private String titulo;
    private String texto;
    private String rutaImagen;
    private String colorFondo;
    private List<Estudio> estudios;
    private List<Habilidad> habilidades;
    private List<Trabajo> experiencia;
    private List<Proyecto> proyectos;

    public Seccion() {
    }

    public Seccion(String nombre, String titulo, String texto, String rutaImagen, String colorFondo) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.texto = texto;
        this.rutaImagen = rutaImagen;
        this.colorFondo = colorFondo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }

    public List<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Estudio> estudios) {
        this.estudios = estudios;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Trabajo> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(List<Trabajo> experiencia) {
        this.experiencia = experiencia;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    
    
    
}
