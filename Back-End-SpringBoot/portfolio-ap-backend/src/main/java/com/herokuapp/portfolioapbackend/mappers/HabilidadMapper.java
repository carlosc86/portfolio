/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.HabilidadDTO;
import com.herokuapp.portfolioapbackend.model.Habilidad;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class HabilidadMapper implements IHabilidadMapper{

    @Override
    public HabilidadDTO toDTO(Habilidad habilidad) {
       HabilidadDTO habilidadDto=new HabilidadDTO();
       habilidadDto.setId(habilidad.getId());
       habilidadDto.setNombre(habilidad.getNombre()!=null?habilidad.getNombre():"");
       habilidadDto.setDescripcion(habilidad.getDescripcion()!=null?habilidad.getDescripcion():"");
       habilidadDto.setPorcentaje(habilidad.getPorcentaje());
       return habilidadDto;
    }

    @Override
    public Habilidad toEntity(HabilidadDTO habilidadDTO) {
        Habilidad habilidad=new Habilidad();
        habilidad.setId(habilidadDTO.getId());
        habilidad.setNombre(habilidadDTO.getNombre()!=null?habilidadDTO.getNombre():"");
        habilidad.setDescripcion(habilidadDTO.getDescripcion()!=null?habilidadDTO.getDescripcion():"");
        habilidad.setPorcentaje(habilidadDTO.getPorcentaje());
        return habilidad;
    }

   
    
}
