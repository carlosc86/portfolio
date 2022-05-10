/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.SeccionDTO;
import com.herokuapp.portfolioapbackend.model.Seccion;
import com.herokuapp.portfolioapbackend.validators.ManejadorValidacion;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class SeccionMapper implements ISeccionMapper{
    
    private ManejadorValidacion validacion=new ManejadorValidacion();

    @Override
    public SeccionDTO toDTO(Seccion seccion) {
        SeccionDTO seccionDto=new SeccionDTO();
        seccionDto.setId(seccion.getId());
        seccionDto.setNombre(seccion.getNombre()!=null?seccion.getNombre():"");
        seccionDto.setTitulo(seccion.getTitulo()!=null?seccion.getTitulo():"");
        seccionDto.setTexto(seccion.getTexto()!=null?seccion.getTexto():"");
        seccionDto.setRutaImagen(seccion.getRutaImagen()!=null?seccion.getRutaImagen():"");
        seccionDto.setColorFondo(seccion.getColorFondo()!=null?seccion.getColorFondo():"");
        return seccionDto;
    }

    @Override
    public Seccion toEntity(SeccionDTO seccionDTO)throws Exception {
        Seccion seccion=new Seccion();
        seccion.setId(seccionDTO.getId());
        seccion.setNombre(seccionDTO.getNombre()!=null?seccionDTO.getNombre():"");
        seccion.setTitulo(seccionDTO.getTitulo()!=null?seccionDTO.getTitulo():"");
        seccion.setTexto(seccionDTO.getTexto()!=null?seccionDTO.getTexto():"");
        seccion.setRutaImagen(seccionDTO.getRutaImagen()!=null?seccionDTO.getRutaImagen():"");
        seccion.setColorFondo(seccionDTO.getColorFondo()!=null?seccionDTO.getColorFondo():"");
        return seccion;
    }

   
}
