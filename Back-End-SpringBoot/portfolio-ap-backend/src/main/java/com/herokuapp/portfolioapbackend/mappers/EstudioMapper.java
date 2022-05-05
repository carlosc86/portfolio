/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.EstudioDTO;
import com.herokuapp.portfolioapbackend.model.Estudio;
import com.herokuapp.portfolioapbackend.model.Institucion;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
//Esto funciona como fachada de la libreria para una clase concreta

@Service
public class EstudioMapper implements IEstudioMapper{
    
    @Override
    public EstudioDTO toDTO(Estudio estudio) {  
        EstudioDTO estudioDto=new EstudioDTO();
        estudioDto.setId(estudio.getId());
        estudioDto.setTitulo(estudio.getTitulo()!=null?estudio.getTitulo():"");
        Institucion institucion=estudio.getInstitucion();
        estudioDto.setNombreInstitucion(institucion.getNombre()!=null?institucion.getNombre():"");
        estudioDto.setDireccionInstitucion(institucion.getDireccion()!=null?institucion.getDireccion():"");
        estudioDto.setRutaLogoInstitucion(institucion.getRutaLogo()!=null?institucion.getRutaLogo():"");
        estudioDto.setFechaInicio(estudio.getFechaInicio().getYear());
        estudioDto.setFechaFin(estudio.getFechaFin().getYear());
        return estudioDto;
    }

    @Override
    public Estudio toEntity(EstudioDTO estudioDto) {
        Estudio estudio=new Estudio();
        estudio.setId(estudioDto.getId()>=0?estudioDto.getId():0);
        estudio.setTitulo(estudioDto.getTitulo()!=null?estudioDto.getTitulo():"");
        estudio.setFechaInicio(LocalDate.of(estudioDto.getFechaInicio(), Month.JANUARY, 1));
        estudio.setFechaFin(LocalDate.of(estudioDto.getFechaFin(), Month.JANUARY, 1));
        estudio.setInstitucion(new Institucion());
        estudio.getInstitucion().setId(0L);
        estudio.getInstitucion().setNombre(estudioDto.getNombreInstitucion()!=null?estudioDto.getNombreInstitucion():"");
        estudio.getInstitucion().setDireccion(estudioDto.getDireccionInstitucion()!=null?estudioDto.getDireccionInstitucion():"");
        estudio.getInstitucion().setRutaLogo(estudioDto.getRutaLogoInstitucion()!=null?estudioDto.getRutaLogoInstitucion():"");
        return estudio;
    }
    
}
