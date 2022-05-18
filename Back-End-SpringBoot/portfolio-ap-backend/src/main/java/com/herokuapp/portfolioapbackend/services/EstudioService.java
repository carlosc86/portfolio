/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.EstudioNotFoundException;
import com.herokuapp.portfolioapbackend.model.Estudio;
import com.herokuapp.portfolioapbackend.model.Institucion;
import com.herokuapp.portfolioapbackend.repository.EstudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class EstudioService implements IEstudioService{
    
    @Autowired
    private EstudioRepository estudioRepo;
    
    @Autowired
    private IInstitucionService institucionService;

    @Override
    public List<Estudio> traer() {
        return estudioRepo.findAll();
    }

    @Override
    public Estudio traer(Long id) throws EstudioNotFoundException{
        Estudio estudio=estudioRepo.findById(id).orElse(null);
        if(estudio==null)throw new EstudioNotFoundException("Valor de id: "+id);
        return estudio;
    }

    @Override
    public Estudio guardar(Estudio estudio) {
        Institucion inst=this.comprobarInstitucion(estudio.getInstitucion());
        estudio.setInstitucion(inst); 
        return estudioRepo.save(estudio);
    }

    @Override
    public void modificar(Estudio estudio)throws EstudioNotFoundException {
        Estudio guardado=traer(estudio.getId());
        if(guardado!=null){
            guardado.setTitulo(estudio.getTitulo());
            guardado.setFechaInicio(estudio.getFechaInicio());
            guardado.setFechaFin(estudio.getFechaFin());
            Institucion institucion=this.comprobarInstitucion(estudio.getInstitucion());//Compruebo contra la db si hay una institucion llamada asi.
            institucion.setDireccion(estudio.getInstitucion().getDireccion().length()>0?//La institucion tiene nueva direccion, (no es cadena vacia)
                                     estudio.getInstitucion().getDireccion():           //Si es asi guardo esa cadena
                                     institucion.getDireccion());                       //sino mantengo la direccion que tenia
            
            institucion.setRutaLogo(estudio.getInstitucion().getRutaLogo().length()>0?  //La institucion tiene un nuevo logo (no es cadena vacia)
                                    estudio.getInstitucion().getRutaLogo():             //Si es asi guardo la nueva cadena
                                    institucion.getRutaLogo());                         //sino mantengo la que tenia
            
            guardado.setInstitucion(institucion);
            estudioRepo.save(guardado);
        }
        
    }

    @Override
    public void borrar(Long id) {
        estudioRepo.deleteById(id);
    }
    
    private Institucion comprobarInstitucion(Institucion inst){
        Institucion guardada=null;
        if(inst!=null){
            if(inst.getId()>0){
                guardada=institucionService.traer(inst.getId());
            }else{
                guardada=institucionService.traer(inst.getNombre());
            }
            if(guardada==null){
                guardada=institucionService.guardar(inst);
            }            
        }//else lanzar excepcion, institucion nula
        
        return guardada;
    }
    
    
}
