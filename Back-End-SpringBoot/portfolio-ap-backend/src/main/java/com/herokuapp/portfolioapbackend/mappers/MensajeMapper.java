/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.MensajeDTO;
import com.herokuapp.portfolioapbackend.model.Mensaje;
import com.herokuapp.portfolioapbackend.model.Visitante;
import com.herokuapp.portfolioapbackend.validators.ManejadorValidacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class MensajeMapper implements IMensajeMapper{
    
    private ManejadorValidacion validacion=new ManejadorValidacion();

    @Override
    public MensajeDTO toDTO(Mensaje entidad) {
        MensajeDTO mensajeDto=new MensajeDTO();
        mensajeDto.setId(entidad.getId());
        mensajeDto.setTitulo(entidad.getTitulo()!=null?entidad.getTitulo():"");
        mensajeDto.setCuerpo(entidad.getCuerpo()!=null?entidad.getCuerpo():"");
        mensajeDto.setLeido(entidad.isLeido());
        mensajeDto.setFecha(entidad.getFecha().format(DateTimeFormatter.ISO_LOCAL_DATE));
        mensajeDto.setNombreAutor(entidad.getAutor().getNombre()!=null?entidad.getAutor().getNombre():"");
        mensajeDto.setApellidoAutor(entidad.getAutor().getApellido()!=null?entidad.getAutor().getApellido():"");
        mensajeDto.setEmailAutor(entidad.getAutor().getEmail()!=null?entidad.getAutor().getEmail():"");
        
        return mensajeDto;
    }

    @Override
    public Mensaje toEntity(MensajeDTO objetoDTO) throws Exception {
        Mensaje mensaje=new Mensaje();
        mensaje.setId(objetoDTO.getId());
        /*Valido cada campo antes de guardarlo, busco que no sean nulos ni cadenas vacias*/
        validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getTitulo());
        mensaje.setTitulo(objetoDTO.getTitulo());
        validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getCuerpo());
        mensaje.setCuerpo(objetoDTO.getCuerpo());
        
        mensaje.setLeido(objetoDTO.getLeido());
        
        /*valido la cadena que trae la fecha */
        validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getFecha());
        /*ahora valido la fecha*/
        LocalDate fecha=LocalDate.parse(objetoDTO.getFecha(),DateTimeFormatter.ISO_LOCAL_DATE);
        validacion.nueva().pasadoDe(LocalDate.now()).validar(fecha);
        mensaje.setFecha(fecha);
        
        mensaje.setAutor(new Visitante());
        mensaje.getAutor().setId(0L);
        /*Por cada valor de string compruebo que no sean nulos ni cadenas vacias y luego
        las guardo*/
        validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getNombreAutor());
        mensaje.getAutor().setNombre(objetoDTO.getNombreAutor());
        validacion.nueva().noNulo().cadenaNoVacia().validar(objetoDTO.getApellidoAutor());
        mensaje.getAutor().setApellido(objetoDTO.getApellidoAutor());
        validacion.nueva()
                .noNulo()
                .cadenaNoVacia()
                .email()
                .validar(objetoDTO.getEmailAutor());
        mensaje.getAutor().setEmail(objetoDTO.getEmailAutor());
        return mensaje;
    }
    
}
