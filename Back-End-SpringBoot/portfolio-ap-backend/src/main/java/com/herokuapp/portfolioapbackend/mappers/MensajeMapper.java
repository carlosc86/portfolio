/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.MensajeDTO;
import com.herokuapp.portfolioapbackend.model.Mensaje;
import com.herokuapp.portfolioapbackend.model.Visitante;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class MensajeMapper implements IMensajeMapper{

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
    public Mensaje toEntity(MensajeDTO objetoDTO) {
        Mensaje mensaje=new Mensaje();
        mensaje.setId(objetoDTO.getId());
        mensaje.setTitulo(objetoDTO.getTitulo()!=null?objetoDTO.getTitulo():"");
        mensaje.setCuerpo(objetoDTO.getCuerpo()!=null?objetoDTO.getCuerpo():"");
        mensaje.setLeido(objetoDTO.getLeido());
        mensaje.setFecha(LocalDate.parse(objetoDTO.getFecha(),DateTimeFormatter.ISO_LOCAL_DATE));
        mensaje.setAutor(new Visitante());
        mensaje.getAutor().setId(0L);
        mensaje.getAutor().setNombre(objetoDTO.getNombreAutor()!=null?objetoDTO.getNombreAutor():"");
        mensaje.getAutor().setApellido(objetoDTO.getApellidoAutor()!=null?objetoDTO.getApellidoAutor():"");
        mensaje.getAutor().setEmail(objetoDTO.getEmailAutor()!=null?objetoDTO.getEmailAutor():"");
        return mensaje;
    }
    
}
