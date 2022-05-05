/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.repository;

import com.herokuapp.portfolioapbackend.model.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public interface InstitucionRepository extends JpaRepository<Institucion,Long>{
    public Institucion findByNombre(String nombre);
}
