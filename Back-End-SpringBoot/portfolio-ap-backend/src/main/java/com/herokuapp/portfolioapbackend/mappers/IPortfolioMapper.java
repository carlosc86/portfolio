/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.mappers;

import com.herokuapp.portfolioapbackend.dto.PortfolioDTO;
import com.herokuapp.portfolioapbackend.model.Estudio;
import com.herokuapp.portfolioapbackend.model.Habilidad;
import com.herokuapp.portfolioapbackend.model.MedioContacto;
import com.herokuapp.portfolioapbackend.model.Proyecto;
import com.herokuapp.portfolioapbackend.model.Seccion;
import com.herokuapp.portfolioapbackend.model.Trabajo;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IPortfolioMapper {
    
    public PortfolioDTO toDTO(List<Seccion> secciones, List<Estudio> estudios, List<Habilidad> habilidades, List<Trabajo> experiencias, List<Proyecto> proyectos, List<MedioContacto> mediosContacto)throws Exception;
    
    
}
