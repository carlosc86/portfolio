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
public class Usuario extends Persona {
    
    private String nombreUsuario;
    private String password;
    private Date ultimoAcceso;
    private Privilegio privilegios;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password, Date ultimoAcceso, Privilegio privilegios) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.ultimoAcceso = ultimoAcceso;
        this.privilegios = privilegios;
    }

    public Privilegio getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Privilegio privilegios) {
        this.privilegios = privilegios;
    }
    
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
    
    
    
}
