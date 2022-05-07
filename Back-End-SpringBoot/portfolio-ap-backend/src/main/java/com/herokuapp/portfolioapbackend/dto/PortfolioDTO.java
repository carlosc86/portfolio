/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.dto;

import com.herokuapp.portfolioapbackend.mappers.EstudioMapper;
import com.herokuapp.portfolioapbackend.mappers.IEstudioMapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlos
 */
@Getter @Setter
public class PortfolioDTO implements Serializable{
   
    private List<SeccionDTO> secciones=new ArrayList();
    private List<EstudioDTO> estudios=new ArrayList();
    private List<HabilidadDTO> habilidades=new ArrayList();
    private List<ExperienciaLaboralDTO> experiencias=new ArrayList();
    private List<ProyectoDTO> proyectos=new ArrayList();
    private List<MedioContactoDTO> medios_contacto=new ArrayList();

    public PortfolioDTO() {
        
    }
    
    
    
}
