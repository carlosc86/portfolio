/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.UsuarioCompletoDTO;
import com.herokuapp.portfolioapbackend.dto.UsuarioDTO;
import com.herokuapp.portfolioapbackend.model.Privilegio;
import com.herokuapp.portfolioapbackend.model.Usuario;
import com.herokuapp.portfolioapbackend.validators.ManejadorValidacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class UsuarioCompletoMapper extends UsuarioMapper{
    
    private ManejadorValidacion validacion=new ManejadorValidacion();
    
     @Override
    public UsuarioCompletoDTO toDTO(Usuario usuario) {
        UsuarioCompletoDTO usuarioDto=new UsuarioCompletoDTO();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setApellido(usuario.getApellido());
        usuarioDto.setRutaIcono(usuario.getRutaIcono());
        usuarioDto.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDto.setPrivilegios(usuario.getPrivilegios().getNombre());
        usuarioDto.setUltimoAcceso(usuario.getUltimoAcceso().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        usuarioDto.setFechaNacimiento(usuario.getFechaNacimiento().format(DateTimeFormatter.ISO_LOCAL_DATE));
        return usuarioDto;
    }
    
    public Usuario toEntity(UsuarioCompletoDTO objetoDTO) throws Exception {
        Usuario usuario=new Usuario();
        /*Valido que el dto pasado tenga el atributo id*/
        this.validacion.nueva().noNulo().validar(objetoDTO.getId());
        usuario.setId(Long.MIN_VALUE);
        
        /*Valido la cadena de nombre y la de apellido y luego las asigno al objeto devuelto*/
        this.validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getNombre());
        usuario.setNombre(objetoDTO.getNombre());
        this.validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getApellido());
        usuario.setApellido(objetoDTO.getApellido());
        
        
        usuario.setPassword(objetoDTO.getPassword());
        
        usuario.setRutaIcono(objetoDTO.getRutaIcono());
        
        Privilegio privilegios=new Privilegio();
        this.validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getPrivilegios());
        privilegios.setNombre(objetoDTO.getPrivilegios());
        usuario.setPrivilegios(privilegios);
        /*verifico que el nombre de usuario no sea cadena vacia*/
        this.validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getNombreUsuario());
        usuario.setNombreUsuario(objetoDTO.getNombreUsuario());
        
        /*Valido que el campo con la fecha de nacimiento sea un string valido*/
        this.validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getFechaNacimiento());
        /*Valido que la fecha obtenida del string sea una fecha del pasado*/
        LocalDate fechaNacimiento=LocalDate.parse(objetoDTO.getFechaNacimiento(),DateTimeFormatter.ISO_LOCAL_DATE);
        this.validacion.nueva().pasado().validar(fechaNacimiento);
        usuario.setFechaNacimiento(fechaNacimiento);
        
        return usuario;
    }
    
    
    
}
