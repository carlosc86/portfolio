/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesbasicas.model;

/**
 *
 * @author carlos
 */
public class Institucion extends Lugar{

    public Institucion() {
    }
    
    public Institucion(String nombre, String direccion, String rutaLogo) {
        this.nombre=nombre;
        this.direccion=direccion;
        this.rutaLogo=rutaLogo;
    }
    
    
    
}
