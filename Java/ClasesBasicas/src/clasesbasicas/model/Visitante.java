/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesbasicas.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class Visitante extends Persona {
    
    private String email;
    private List<Mensaje> mensajes=new ArrayList();

    public Visitante() {
    }

    public Visitante(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    public void setMensaje(Mensaje mensaje){
        this.mensajes.add(mensaje);
    }
    
    
    
    
}
