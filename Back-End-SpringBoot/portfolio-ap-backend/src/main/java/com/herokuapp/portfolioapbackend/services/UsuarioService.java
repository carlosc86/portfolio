/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.model.Privilegio;
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
    @Autowired
    private IPrivilegioService priviService;

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
            String password=this.gestionarPassword(usuario.getPassword(),guardado.getPassword());
            if(password!=null){ //si es igual a la anterior o es nula no pasa este chequeo                
                guardado.setPassword(password);
            }
            guardado.setPrivilegios(this.gestionarPrivilegio(usuario.getPrivilegios()));
            if(usuario.getUltimoAcceso()!=null){
                guardado.setUltimoAcceso(usuario.getUltimoAcceso());
            }
            guardado.setRutaIcono(usuario.getRutaIcono());
            usuarioRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        usuarioRepo.deleteById(id);
    }
    
    private Privilegio gestionarPrivilegio(Privilegio privilegio){
        Privilegio guardado=priviService.traer(privilegio.getNombre());
        if(guardado==null){
            guardado=priviService.guardar(privilegio);
        }
        return guardado;
    }
    
    private String gestionarPassword(String nuevaPass,String viejaPass){
        String passGestionada=null;
        if(nuevaPass!=null){//Si la nueva es distinta de null
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            if((nuevaPass!=viejaPass)&&!(encoder.matches(nuevaPass, viejaPass))){ //y no es igual a la guardada
                String nuevaEncriptada=encoder.encode(nuevaPass);
                passGestionada=nuevaEncriptada;//asigno la nueva pass
            }
        }
        return passGestionada;
    }
}
