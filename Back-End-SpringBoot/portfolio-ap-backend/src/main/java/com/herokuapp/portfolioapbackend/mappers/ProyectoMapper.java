/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.ProyectoDTO;
import com.herokuapp.portfolioapbackend.model.Proyecto;
import com.herokuapp.portfolioapbackend.validators.ManejadorValidacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ProyectoMapper implements IProyectoMapper{
    
    private ManejadorValidacion validacion=new ManejadorValidacion();

    @Override
    public ProyectoDTO toDTO(Proyecto proyecto) {
        ProyectoDTO proyectoDto=new ProyectoDTO();
        proyectoDto.setId(proyecto.getId());
        proyectoDto.setNombre(proyecto.getNombre()!=null?proyecto.getNombre():"");
        proyectoDto.setDescripcion(proyecto.getDescripcion()!=null?proyecto.getDescripcion():"");
        proyectoDto.setLink(proyecto.getUrl()!=null?proyecto.getUrl():"");
        proyectoDto.setFecha(proyecto.getFecha().format(DateTimeFormatter.ISO_LOCAL_DATE));
        String[] rutasImagenes=new String[proyecto.getImagenes().size()];
        for (int i = 0; i < proyecto.getImagenes().size(); i++) {
            rutasImagenes[i]=proyecto.getImagenes().get(i).getUrlImagen();
        }
        proyectoDto.setRutasImagenes(rutasImagenes);
        return proyectoDto;
    }

    @Override
    public Proyecto toEntity(ProyectoDTO proyectoDTO)throws Exception {
        Proyecto proyecto=new Proyecto();
        proyecto.setId(proyectoDTO.getId());
        validacion.nueva().noNulo().cadenaNoVacia().validar(proyectoDTO.getNombre());
        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setDescripcion(proyectoDTO.getDescripcion()!=null?proyectoDTO.getDescripcion():"");
        
        /*Valido que la url del campo link tenga el formato correcto*/
        validacion.nueva()
                .noNulo()
                .cadenaNoVacia()
                .url()
                .validar(proyectoDTO.getLink());
        proyecto.setUrl(proyectoDTO.getLink()!=null?proyectoDTO.getLink():"");
        
        validacion.nueva().noNulo().cadenaNoVacia().validar(proyectoDTO.getFecha());
        LocalDate fecha=LocalDate.parse(proyectoDTO.getFecha(), DateTimeFormatter.ISO_LOCAL_DATE);
        validacion.nueva().pasadoDe(LocalDate.now()).validar(fecha);
        proyecto.setFecha(fecha);
        for (int i = 0; i < proyectoDTO.getRutasImagenes().length; i++) {
            proyecto.setImagen(proyectoDTO.getRutasImagenes()[i], "");
        }        
        return proyecto;
    }

   
    
}
