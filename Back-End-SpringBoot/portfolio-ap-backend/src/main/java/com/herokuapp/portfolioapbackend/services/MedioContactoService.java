/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.MedioContactoNotFoundException;
import com.herokuapp.portfolioapbackend.model.MedioContacto;
import com.herokuapp.portfolioapbackend.model.TipoMedioContacto;
import com.herokuapp.portfolioapbackend.repository.MedioContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class MedioContactoService implements IMedioContactoService{
    @Autowired
    private MedioContactoRepository medioRepo;
    
    @Autowired
    private ITipoMedioContactoService tipoService;

    @Override
    public List<MedioContacto> traer() {
        return medioRepo.findAll();
    }

    @Override
    public MedioContacto traer(Long id)throws MedioContactoNotFoundException {
        MedioContacto medioContacto=medioRepo.findById(id).orElse(null);
        if(medioContacto==null)throw new MedioContactoNotFoundException("Valor de id: "+id);
        return medioContacto;
    }

    @Override
    public MedioContacto guardar(MedioContacto medio) {
        medio=this.gestionarTipo(medio);
        return medioRepo.save(medio);
    }

    @Override
    public void modificar(MedioContacto medio)throws MedioContactoNotFoundException {
        MedioContacto guardado=traer(medio.getId());
        if(guardado!=null){
            guardado.setLink(medio.getLink());
            guardado=this.gestionarTipo(guardado);
            medioRepo.save(guardado);
        }
    }

    @Override
    public void borrar(Long id) {
        medioRepo.deleteById(id);
    }

    private String obtenerEmpresa(String link) {
        String[] cadenas=link.split("\\.|\\/");
        String empresa="";
        for (int i = 0; i < cadenas.length; i++) {
            if((i+1)<cadenas.length &&//Si el indice esta dentro de los limites de la lista
                    (cadenas[i+1].equalsIgnoreCase("com")||cadenas[i+1].equalsIgnoreCase("net")||//Revisa la siguiente palabra
                    cadenas[i+1].equalsIgnoreCase("org")||cadenas[i+1].equalsIgnoreCase("fm"))){//si es com, org, net, fm 
                empresa=cadenas[i];//la cadena anterior es el nombre de la empresa
            }
        }
        return empresa;
    }
    
    private MedioContacto gestionarTipo(MedioContacto medio){
        String empresa=obtenerEmpresa(medio.getLink());
        TipoMedioContacto tipo=tipoService.traer(empresa);
        if(tipo==null){
            tipo=new TipoMedioContacto();
            tipo.setEmpresa(empresa);
            tipo=tipoService.guardar(tipo);            
        }
        medio.setTipo(tipo);
        return medio;
    }
    
}
