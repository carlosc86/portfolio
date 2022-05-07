/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.UsuarioDTO;
import com.herokuapp.portfolioapbackend.model.Usuario;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class UsuarioMapper implements IUsuarioMapper{

    @Override
    public UsuarioDTO toDTO(Usuario entidad) {
        UsuarioDTO usuarioDto=new UsuarioDTO();
        usuarioDto.setNombre(entidad.getNombre());
        usuarioDto.setApellido(entidad.getApellido());
        usuarioDto.setRutaIcono(entidad.getRutaIcono());
        usuarioDto.setNombreUsuario(entidad.getNombreUsuario());
        return usuarioDto;
    }

    @Override
    public Usuario toEntity(UsuarioDTO objetoDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
