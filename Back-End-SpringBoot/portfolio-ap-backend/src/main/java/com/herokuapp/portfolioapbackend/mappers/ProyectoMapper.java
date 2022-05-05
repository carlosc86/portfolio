/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.ProyectoDTO;
import com.herokuapp.portfolioapbackend.model.Proyecto;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ProyectoMapper implements IProyectoMapper{

    @Override
    public ProyectoDTO toDTO(Proyecto proyecto) {
        ProyectoDTO proyectoDto=new ProyectoDTO();
        proyectoDto.setId(proyecto.getId());
        proyectoDto.setNombre(proyecto.getNombre()!=null?proyecto.getNombre():"");
        proyectoDto.setDescripcion(proyecto.getDescripcion()!=null?proyecto.getDescripcion():"");
        proyectoDto.setLink(proyecto.getUrl()!=null?proyecto.getUrl():"");
        proyectoDto.setFecha(proyecto.getFecha().getYear());
        String[] rutasImagenes=new String[proyecto.getImagenes().size()];
        for (int i = 0; i < proyecto.getImagenes().size(); i++) {
            rutasImagenes[i]=proyecto.getImagenes().get(i).getUrlImagen();
        }
        proyectoDto.setRutasImagenes(rutasImagenes);
        return proyectoDto;
    }

    @Override
    public Proyecto toEntity(ProyectoDTO proyectoDTO) {
        Proyecto proyecto=new Proyecto();
        proyecto.setId(proyectoDTO.getId());
        proyecto.setNombre(proyectoDTO.getNombre()!=null?proyectoDTO.getNombre():"");
        proyecto.setDescripcion(proyectoDTO.getDescripcion()!=null?proyectoDTO.getDescripcion():"");
        proyecto.setUrl(proyectoDTO.getLink()!=null?proyectoDTO.getLink():"");
        proyecto.setFecha(LocalDate.of(proyectoDTO.getFecha(), 1, 1));
        for (int i = 0; i < proyectoDTO.getRutasImagenes().length; i++) {
            proyecto.setImagen(proyectoDTO.getRutasImagenes()[i], "");
        }        
        return proyecto;
    }

   
    
}
