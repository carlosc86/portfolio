/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.repository;

import com.herokuapp.portfolioapbackend.model.Visitante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public interface VisitanteRepository extends JpaRepository<Visitante,Long>{
    public List<Visitante> findByNombre(String nombre);
    public List<Visitante> findByApellido(String apellido);
    
    @Query(value="SELECT * FROM visitantes v WHERE v.nombre=?1 and v.apellido=?2 and v.email=?3",
            nativeQuery=true)
    public Visitante findByNombreApellidoAndEmail(String nombre, String apellido, String email); 
}
