/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public abstract class GenericMapper<DTO,ENTIDAD> implements IGenericMapper<DTO,ENTIDAD> {
    
    public List<DTO> toDTOList(List<ENTIDAD> lista) throws Exception{
        List<DTO> retorno=new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add((DTO) this.toDTO(lista.get(i)));
        }
        return retorno;
    }
    
}
