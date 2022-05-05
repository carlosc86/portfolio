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
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class PortfolioMapper implements IPortfolioMapper{

    @Override
    public PortfolioDTO toDTO(List<Seccion> secciones, List<Estudio> estudios, List<Habilidad> habilidades, List<Trabajo> experiencias, List<Proyecto> proyectos, List<MedioContacto> mediosContacto) {
        PortfolioDTO portfolio=new PortfolioDTO();
        portfolio.setSecciones(convertirADTO(secciones,new SeccionMapper()));
        portfolio.setEstudios(convertirADTO(estudios,new EstudioMapper()));
        portfolio.setHabilidades(convertirADTO(habilidades,new HabilidadMapper()));
        portfolio.setExperiencias(convertirADTO(experiencias,new ExperienciaLaboralMapper()));
        portfolio.setProyectos(convertirADTO(proyectos,new ProyectoMapper()));
        portfolio.setMedios_contacto(convertirADTO(mediosContacto,new MedioContactoMapper()));
        
        return portfolio;
    }
    
    private List convertirADTO(List elemento,IGenericMapper mapeador){
        List retorno=new ArrayList();
        for (int i = 0; i < elemento.size(); i++) {
            retorno.add(mapeador.toDTO(elemento.get(i)));
        }
        return retorno;
    }

    
}
