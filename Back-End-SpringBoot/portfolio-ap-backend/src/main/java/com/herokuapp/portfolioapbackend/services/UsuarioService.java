/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Usuario;
import com.herokuapp.portfolioapbackend.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public List<Usuario> traer() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario traer(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public Usuario traer(String nombreUsuario) {
        return usuarioRepo.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));//Antes de guardar encripto la password
        return usuarioRepo.save(usuario);
    }

    @Override
    public void modificar(Usuario usuario) {
        Usuario guardado=traer(usuario.getNombreUsuario());
        if (guardado!=null) {
            guardado.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
            guardado.setPrivilegios(usuario.getPrivilegios());
            guardado.setUltimoAcceso(usuario.getUltimoAcceso());
            usuarioRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        usuarioRepo.deleteById(id);
    }
    
}
