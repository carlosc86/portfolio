/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.model.Usuario;
import com.herokuapp.portfolioapbackend.services.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlos
 */
//@PreAuthorize("authenticated")
@CrossOrigin(origins="https://portfolio-carricondo.firebaseapp.com")//Por ahora asi para poder usar angular
@RestController
public class UsuarioController {
    /*
        CUIDADO!!!, ESTE CONTROLADOR ESTA TRABAJANDO CON ENTIDADES, REHACER!!!
    */
    
    @Autowired
    private IUsuarioService usuarioService;
    
    
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.traer();
    }
    
    @GetMapping("/usuarios/{id}")
    @ResponseBody
    public Usuario getUsuario(@PathVariable("id") Long id){
        return usuarioService.traer(id);
    }
    
    @PostMapping("/usuarios")
    public Usuario postUsuario(@RequestBody Usuario usuario ){
        return usuarioService.guardar(usuario);
    }
    
    @PutMapping("/usuarios/{id}")
    public void putUsuario(@PathVariable Long id, @RequestBody Usuario usuario ){
        if(id==usuario.getId())
            usuarioService.modificar(usuario);
    }
    
    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable Long id){
        usuarioService.borrar(id);
    }
    
    
}
