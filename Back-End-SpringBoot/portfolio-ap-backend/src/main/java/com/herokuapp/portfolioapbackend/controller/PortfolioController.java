/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.PortfolioDTO;
import com.herokuapp.portfolioapbackend.mappers.IPortfolioMapper;
import com.herokuapp.portfolioapbackend.services.IEstudioService;
import com.herokuapp.portfolioapbackend.services.IHabilidadService;
import com.herokuapp.portfolioapbackend.services.IMedioContactoService;
import com.herokuapp.portfolioapbackend.services.IProyectoService;
import com.herokuapp.portfolioapbackend.services.ISeccionService;
import com.herokuapp.portfolioapbackend.services.ITrabajoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlos
 */
@CrossOrigin(origins="http://localhost:4200")//Por ahora asi para poder usar angular
@RestController
public class PortfolioController {
    
    @Autowired
    private IPortfolioMapper portfolioMapper;
    
    @Autowired
    private ISeccionService seccionService;
    
    @Autowired
    private IMedioContactoService medioService;
    
    @Autowired
    private IEstudioService estudioService;
    
    @Autowired
    private IHabilidadService habilidadService;
    
    @Autowired
    private ITrabajoService trabajoService;
    
    @Autowired
    private IProyectoService proyectoService;
    
    @CrossOrigin(origins="http://localhost:4200")//Por ahora asi para poder usar angular
    @GetMapping("/portfolio")
    @ResponseBody
    public List<PortfolioDTO> getPortfolio(){
        PortfolioDTO portfolio= portfolioMapper.toDTO(  seccionService.traer(),
                                                        estudioService.traer(),
                                                        habilidadService.traer(),
                                                        trabajoService.traer(),
                                                        proyectoService.traer(),
                                                        medioService.traer());
        List<PortfolioDTO> retorno=new ArrayList();
        retorno.add(portfolio);
        return retorno;
    }
    
}
