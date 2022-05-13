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
import com.herokuapp.portfolioapbackend.validators.ManejadorValidacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ExperienciaLaboralMapper implements IExperienciaLaboralMapper {
    
    private ManejadorValidacion validacion=new ManejadorValidacion();

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
    public Trabajo toEntity(ExperienciaLaboralDTO experienciaDTO)throws Exception {
        Trabajo trabajo=new Trabajo();
        trabajo.setId(experienciaDTO.getId());
        /*Valido que el string del puesto no sea nulo ni vacio*/
        validacion.nueva().noNulo().cadenaNoVacia().validar(experienciaDTO.getPuesto());
        trabajo.setPuesto(experienciaDTO.getPuesto());
        trabajo.setDescripcion(experienciaDTO.getDescripcion()!=null?experienciaDTO.getDescripcion():"");
        
        /*valido la fecha de finalizacion, primero que la cadena sea valida*/
        validacion.nueva()
                .noNulo()
                .cadenaNoVacia()
                .validar(experienciaDTO.getFechaFin());
        /*luego verifico que la fecha en si sea una fecha del pasado*/
        LocalDate fechaFin=LocalDate.parse(experienciaDTO.getFechaFin(),DateTimeFormatter.ISO_LOCAL_DATE);
        validacion.nueva()
                .pasado()
                .validar(fechaFin);
        trabajo.setFechaFin(fechaFin);
        
        /*Verifico que el string de la fecha de inicio sea valido*/
        validacion.nueva()
                .noNulo()
                .cadenaNoVacia()
                .validar(experienciaDTO.getFechaInicio());
        /*Luego verifico que la fecha sea anterior a la fecha de finalizacion*/
        LocalDate fechaInicio=LocalDate.parse(experienciaDTO.getFechaInicio(),DateTimeFormatter.ISO_LOCAL_DATE);
        validacion.nueva()
                .pasadoDe(trabajo.getFechaFin())
                .validar(fechaInicio);
        trabajo.setFechaInicio(fechaInicio);
       
        Empresa empresa=new Empresa();
        
        /*Verifico que el nombre de la empresa no sea nulo o vacio*/
        validacion.nueva()
                .noNulo()
                .cadenaNoVacia()
                .validar(experienciaDTO.getNombreEmpresa());
        empresa.setNombre(experienciaDTO.getNombreEmpresa());
        empresa.setDireccion(experienciaDTO.getDireccionEmpresa());
        empresa.setRutaLogo(experienciaDTO.getRutaLogoEmpresa());
        trabajo.setEmpresa(empresa);
        TipoTrabajo tipo=new TipoTrabajo();
        
        /*Verifico que el nombre del tipo de trabajo no sea nulo o vacio,*/
        validacion.nueva()
                .noNulo()
                .cadenaNoVacia()
                .validar(experienciaDTO.getTipoTrabajo());
        tipo.setNombre(experienciaDTO.getTipoTrabajo());
        trabajo.setTipo(tipo);
        return trabajo;
    }
    
}
