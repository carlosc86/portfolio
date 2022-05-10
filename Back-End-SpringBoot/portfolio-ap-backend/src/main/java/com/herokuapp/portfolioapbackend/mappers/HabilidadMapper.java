/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.HabilidadDTO;
import com.herokuapp.portfolioapbackend.model.Habilidad;
import com.herokuapp.portfolioapbackend.validators.ManejadorValidacion;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class HabilidadMapper implements IHabilidadMapper{
    
    private ManejadorValidacion validacion=new ManejadorValidacion();

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
    public Habilidad toEntity(HabilidadDTO habilidadDTO)throws Exception {
        Habilidad habilidad=new Habilidad();
        habilidad.setId(habilidadDTO.getId());
        
        /*Verifico que el nombre no sea nulo, ni una cadena vacia*/
        validacion.nueva().noNulo().cadenaNoVacia().validar(habilidadDTO.getNombre());
        habilidad.setNombre(habilidadDTO.getNombre());
        habilidad.setDescripcion(habilidadDTO.getDescripcion()!=null?habilidadDTO.getDescripcion():"");
        /*Verifico que el porcentaje no sea nulo y sea un valor entre 0 y 100*/
        validacion.nueva()
                .noNulo()
                .valorEnteroEntre(1, 100)
                .validar(habilidadDTO.getPorcentaje());
        habilidad.setPorcentaje(habilidadDTO.getPorcentaje());
        return habilidad;
    }

   
    
}
