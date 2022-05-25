/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.TrabajoNotFoundException;
import com.herokuapp.portfolioapbackend.model.Empresa;
import com.herokuapp.portfolioapbackend.model.TipoTrabajo;
import com.herokuapp.portfolioapbackend.model.Trabajo;
import com.herokuapp.portfolioapbackend.repository.TrabajoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class TrabajoService implements ITrabajoService{
    
    @Autowired
    private TrabajoRepository trabajoRepo;
    
    @Autowired
    private IEmpresaService empresaService;
    
    @Autowired
    private ITipoTrabajoService tipoService;

    @Override
    public List<Trabajo> traer() {
        return trabajoRepo.findAll();
    }

    @Override
    public Trabajo traer(Long id) throws TrabajoNotFoundException{
        Trabajo trabajo=trabajoRepo.findById(id).orElse(null);
        if(trabajo==null)throw new TrabajoNotFoundException("Valor de id: "+id);
        return trabajo;
    }

    @Override
    public Trabajo guardar(Trabajo trabajo) {
        Empresa empresa=gestionarEmpresa(trabajo.getEmpresa());
        TipoTrabajo tipo=gestionarTipoTrabajo(trabajo.getTipo());
        trabajo.setEmpresa(empresa);
        trabajo.setTipo(tipo);
        return trabajoRepo.save(trabajo);
    }

    @Override
    public void modificar(Trabajo trabajo) throws TrabajoNotFoundException{
        Trabajo guardado=traer(trabajo.getId());
        if(guardado!=null){
            guardado.setPuesto(trabajo.getPuesto());
            guardado.setDescripcion(trabajo.getDescripcion());
            guardado.setFechaInicio(trabajo.getFechaInicio());
            guardado.setFechaFin(trabajo.getFechaFin());
            Empresa empresa=gestionarEmpresa(trabajo.getEmpresa());
            empresa.setRutaLogo(trabajo.getEmpresa().getRutaLogo());
            empresa.setDireccion(trabajo.getEmpresa().getDireccion());
            TipoTrabajo tipo=gestionarTipoTrabajo(trabajo.getTipo());
            guardado.setEmpresa(empresa);
            guardado.setTipo(tipo);
            trabajoRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        trabajoRepo.deleteById(id);
    }

    private Empresa gestionarEmpresa(Empresa empresa) {
        Empresa retorno=empresaService.traer(empresa.getNombre());
        if(retorno==null){
            retorno=new Empresa();
            retorno.setNombre(empresa.getNombre());
            retorno.setDireccion(empresa.getDireccion());
            retorno.setRutaLogo(empresa.getRutaLogo());
            retorno=empresaService.guardar(retorno);
        }
        return retorno;
    }

    private TipoTrabajo gestionarTipoTrabajo(TipoTrabajo tipo) {
        TipoTrabajo retorno=tipoService.traer(tipo.getNombre());
        if(retorno==null){
            retorno=new TipoTrabajo();
            retorno.setNombre(tipo.getNombre());
            retorno=tipoService.guardar(retorno);
        }
        return retorno;
    }
    
}
