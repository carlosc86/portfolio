/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.MedioContactoDTO;
import com.herokuapp.portfolioapbackend.model.MedioContacto;
import com.herokuapp.portfolioapbackend.model.TipoMedioContacto;
import com.herokuapp.portfolioapbackend.validators.ManejadorValidacion;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class MedioContactoMapper implements IMedioContactoMapper{
    
    private ManejadorValidacion validacion=new ManejadorValidacion();

    @Override
    public MedioContactoDTO toDTO(MedioContacto medio) {
        MedioContactoDTO medioDTO=new MedioContactoDTO();
        medioDTO.setId(medio.getId());
        medioDTO.setLink(medio.getLink()!=null?medio.getLink():"");
        medioDTO.setEmpresa(medio.getTipo().getEmpresa()!=null?medio.getTipo().getEmpresa():"");
        medioDTO.setRutaIcono(medio.getTipo().getRutaIcono()!=null?medio.getTipo().getRutaIcono():"");
        return medioDTO;
    }

    @Override
    public MedioContacto toEntity(MedioContactoDTO medioDTO) throws Exception {
        MedioContacto medio=new MedioContacto();
        medio.setId(medioDTO.getId());
        
        /*Valido que la cadena de caracteres no sea nula, ni que venga vacia*/
        validacion.nueva().noNulo().cadenaNoVacia().validar(medioDTO.getLink());
        medio.setLink(medioDTO.getLink());
        medio.setTipo(new TipoMedioContacto());
        medio.getTipo().setRutaIcono(medioDTO.getRutaIcono()!=null?medioDTO.getRutaIcono():"");
        return medio;
    }

   
}
