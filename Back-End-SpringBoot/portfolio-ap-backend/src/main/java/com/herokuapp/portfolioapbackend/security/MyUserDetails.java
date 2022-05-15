/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.security;

import com.herokuapp.portfolioapbackend.model.Privilegio;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author carlos
 */
public class MyUserDetails implements UserDetails {
    
    private String usuario;
    private String password;
    private Privilegio privilegios;
    

    MyUserDetails(String nombreUsuario, String password, Privilegio privilegios) {
        this.usuario=nombreUsuario;
        this.password=password;
        this.privilegios=privilegios;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+this.privilegios.getNombre().toUpperCase()));//Genero los permisos que provee spring a partir de los que tengo en db
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
