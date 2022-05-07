/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.ExperienciaLaboralDTO;
import com.herokuapp.portfolioapbackend.model.Empresa;
import com.herokuapp.portfolioapbackend.model.TipoTrabajo;
import com.herokuapp.portfolioapbackend.model.Trabajo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ExperienciaLaboralMapper implements IExperienciaLaboralMapper {

    @Override
    public ExperienciaLaboralDTO toDTO(Trabajo experiencia) {
        ExperienciaLaboralDTO experienciaDTO=new ExperienciaLaboralDTO();
        experienciaDTO.setId(experiencia.getId());
        experienciaDTO.setPuesto(experiencia.getPuesto()!=null?experiencia.getPuesto():"");
        experienciaDTO.setDescripcion(experiencia.getDescripcion()!=null?experiencia.getDescripcion():"");
        experienciaDTO.setFechaInicio(experiencia.getFechaInicio().format(DateTimeFormatter.ISO_LOCAL_DATE));
        experienciaDTO.setFechaFin(experiencia.getFechaFin().format(DateTimeFormatter.ISO_LOCAL_DATE));
        Empresa empresa=experiencia.getEmpresa();
        experienciaDTO.setNombreEmpresa(empresa.getNombre()!=null?empresa.getNombre():"");
        experienciaDTO.setDireccionEmpresa(empresa.getDireccion()!=null?empresa.getDireccion():"");
        experienciaDTO.setRutaLogoEmpresa(empresa.getRutaLogo()!=null?empresa.getRutaLogo():"");
        experienciaDTO.setTipoTrabajo(experiencia.getTipo().getNombre()!=null?experiencia.getTipo().getNombre():"");
        return experienciaDTO;
    }

    @Override
    public Trabajo toEntity(ExperienciaLaboralDTO experienciaDTO) {
        Trabajo trabajo=new Trabajo();
        trabajo.setId(experienciaDTO.getId());
        trabajo.setPuesto(experienciaDTO.getPuesto()!=null?experienciaDTO.getPuesto():"");
        trabajo.setDescripcion(experienciaDTO.getDescripcion()!=null?experienciaDTO.getDescripcion():"");
        trabajo.setFechaInicio(LocalDate.parse(experienciaDTO.getFechaInicio(),DateTimeFormatter.ISO_LOCAL_DATE));
        trabajo.setFechaFin(LocalDate.parse(experienciaDTO.getFechaFin(), DateTimeFormatter.ISO_LOCAL_DATE));
        Empresa empresa=new Empresa();
        //empresa.setId(0L);
        empresa.setNombre(experienciaDTO.getNombreEmpresa());
        empresa.setDireccion(experienciaDTO.getDireccionEmpresa());
        empresa.setRutaLogo(experienciaDTO.getRutaLogoEmpresa());
        trabajo.setEmpresa(empresa);
        TipoTrabajo tipo=new TipoTrabajo();
        tipo.setNombre(experienciaDTO.getTipoTrabajo());
        trabajo.setTipo(tipo);
        return trabajo;
    }
    
}
