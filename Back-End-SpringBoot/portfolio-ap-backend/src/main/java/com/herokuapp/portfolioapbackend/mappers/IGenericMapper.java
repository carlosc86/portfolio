/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import java.util.List;

/**
 *
 * @author carlos
 */
public interface IGenericMapper<DTO,ENTIDAD> {
    
    public DTO toDTO(ENTIDAD entidad)throws Exception;
    public ENTIDAD toEntity(DTO objetoDTO)throws Exception;
    
}
