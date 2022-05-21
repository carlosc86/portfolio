/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.UsuarioCompletoDTO;
import com.herokuapp.portfolioapbackend.mappers.UsuarioCompletoMapper;
import com.herokuapp.portfolioapbackend.model.Usuario;
import com.herokuapp.portfolioapbackend.services.IUsuarioService;
import java.util.ArrayList;
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
@CrossOrigin(origins="${portfolio.frontend.url}")//Por ahora asi para poder usar angular
@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @Autowired
    private UsuarioCompletoMapper usuarioMapper;
    
    /*Endpoint para obtener todos los usuarios de la db, por ahora anulado*/
    /*
    @GetMapping("/usuarios")
    public List<UsuarioCompletoDTO> getUsuarios() throws Exception{
        List<Usuario> lista=usuarioService.traer();
        List<UsuarioCompletoDTO> retorno=new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(usuarioMapper.toDTO(lista.get(i)));
        }
        return retorno;
    }
    */
    
    /*Endpoint para obtener un usuario en particular de la db, dado un id*/
    @GetMapping("/usuarios/{id}")
    @ResponseBody
    public UsuarioCompletoDTO getUsuario(@PathVariable("id") Long id) throws Exception{
        return usuarioMapper.toDTO(usuarioService.traer(id));
    }
    
    /*Endpoint para cargar un nuevo usuario, por ahora anulado*/
    /*
    @PostMapping("/usuarios")
    public UsuarioCompletoDTO postUsuario(@RequestBody UsuarioCompletoDTO usuario ) throws Exception{
        //Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo
        return usuarioMapper.toDTO(usuarioService.guardar(usuarioMapper.toEntity(usuario)));
    }
    */
    
    /*Endpoint para modificar un usuario en particular, dado un id*/
    @PutMapping("/usuarios/{id}")
    public void putUsuario(@PathVariable Long id, @RequestBody UsuarioCompletoDTO usuario ) throws Exception{
        if(id==usuario.getId()){
            usuarioService.modificar(usuarioMapper.toEntity(usuario));
        }else throw new Exception("La informacion de id suministrada no coincide.");
    }
    
    /*Endpoint para elmiminar un usuario dado un id, por ahora anulado*/
    /*
    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable Long id){
        usuarioService.borrar(id);
    }
    */
    
}
