/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.MedioContactoDTO;
import com.herokuapp.portfolioapbackend.model.MedioContacto;
import com.herokuapp.portfolioapbackend.model.TipoMedioContacto;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class MedioContactoMapper implements IMedioContactoMapper{

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
    public MedioContacto toEntity(MedioContactoDTO medioDTO) {
        MedioContacto medio=new MedioContacto();
        medio.setId(medioDTO.getId());
        medio.setLink(medioDTO.getLink());
        medio.setTipo(new TipoMedioContacto());
        medio.getTipo().setRutaIcono(medioDTO.getRutaIcono()!=null?medioDTO.getRutaIcono():"");
        return medio;
    }

   
}
