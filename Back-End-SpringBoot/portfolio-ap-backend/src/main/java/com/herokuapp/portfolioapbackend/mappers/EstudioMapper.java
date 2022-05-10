/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.EstudioDTO;
import com.herokuapp.portfolioapbackend.model.Estudio;
import com.herokuapp.portfolioapbackend.model.Institucion;
import com.herokuapp.portfolioapbackend.validators.ManejadorValidacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
//Esto funciona como fachada de la libreria para una clase concreta

@Service
public class EstudioMapper implements IEstudioMapper{
    
    
    private ManejadorValidacion validacion = new ManejadorValidacion();
    
    /**
     * Metodo que convierte una entidad Estudio a un DTO para el endpoint
     */
    @Override
    public EstudioDTO toDTO(Estudio estudio)throws Exception {  
        EstudioDTO estudioDto=new EstudioDTO();
        estudioDto.setId(estudio.getId());
        estudioDto.setTitulo(estudio.getTitulo()!=null?estudio.getTitulo():"");
        Institucion institucion=estudio.getInstitucion();
        estudioDto.setNombreInstitucion(institucion.getNombre()!=null?institucion.getNombre():"");
        estudioDto.setDireccionInstitucion(institucion.getDireccion()!=null?institucion.getDireccion():"");
        estudioDto.setRutaLogoInstitucion(institucion.getRutaLogo()!=null?institucion.getRutaLogo():"");
        estudioDto.setFechaInicio(estudio.getFechaInicio().format(DateTimeFormatter.ISO_LOCAL_DATE));
        estudioDto.setFechaFin(estudio.getFechaFin().format(DateTimeFormatter.ISO_LOCAL_DATE));
        return estudioDto;
    }

    /*Metodo que verifica y convierte un dto en una entidad Estudio*/
    @Override
    public Estudio toEntity(EstudioDTO estudioDto)throws Exception {
        Estudio estudio=new Estudio();
        estudio.setId(estudioDto.getId()>=0?estudioDto.getId():0);
        /*Valido que el titulo del estudio este presente*/
        validacion.nueva()
                .noNulo()
                .cadenaNoVacia()
                .validar(estudioDto.getTitulo());
        estudio.setTitulo(estudioDto.getTitulo());//lo guardo
        /*Valido que la fecha de finalizacion del estudio sea correcta*/
        validacion.nueva()
                 .noNulo()
                 .cadenaNoVacia()//Valido primero la cadena de caracteres
                 .validar(estudioDto.getFechaFin());
        validacion.nueva()
                .pasado()//Luego valido que la fecha formada sea en pasado
                .validar(LocalDate.parse(estudioDto.getFechaFin(),DateTimeFormatter.ISO_LOCAL_DATE));
        estudio.setFechaFin(LocalDate.parse(estudioDto.getFechaFin(), DateTimeFormatter.ISO_LOCAL_DATE));
        
        /*Valido que la fecha de inicio enviada es valida*/
        validacion.nueva()
                .noNulo()
                .cadenaNoVacia()
                .validar(estudioDto.getFechaInicio());
        validacion.nueva()
                .noNulo()
                .pasadoDe(estudio.getFechaFin())//que la fecha sea anterior a la fecha de finalizacion
                .validar(LocalDate.parse(estudioDto.getFechaInicio(),DateTimeFormatter.ISO_LOCAL_DATE));
        estudio.setFechaInicio(LocalDate.parse(estudioDto.getFechaInicio(),DateTimeFormatter.ISO_LOCAL_DATE));
        
        estudio.setInstitucion(new Institucion());
        estudio.getInstitucion().setId(0L);
        
        /*Valido el nombre de la institucion que no este vacio*/
        validacion.nueva()
                .noNulo()
                .cadenaNoVacia()
                .validar(estudioDto.getNombreInstitucion());
        estudio.getInstitucion().setNombre(estudioDto.getNombreInstitucion());
        
        /*Estos campos son mas flexibles*/
        estudio.getInstitucion().setDireccion(estudioDto.getDireccionInstitucion()!=null?estudioDto.getDireccionInstitucion():"");
        estudio.getInstitucion().setRutaLogo(estudioDto.getRutaLogoInstitucion()!=null?estudioDto.getRutaLogoInstitucion():"");
        return estudio;
    }
    
}
