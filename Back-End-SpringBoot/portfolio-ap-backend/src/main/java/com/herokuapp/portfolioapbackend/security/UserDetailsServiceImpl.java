/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.security;

import com.herokuapp.portfolioapbackend.model.Usuario;
import com.herokuapp.portfolioapbackend.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Clase implementada para hacer uso de los servicios de authenticacion de 
 * Spring security
 * @author carlos
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario=usuarioService.traer(username);//Basicamente busca al usuario y lo convierte en una clase que spring pueda manejar
        if(usuario==null) throw new UsernameNotFoundException("No se encontró el usuario: "+username );
        return new MyUserDetails(usuario.getNombreUsuario(),usuario.getPassword(),usuario.getPrivilegios());
    }
    
}
