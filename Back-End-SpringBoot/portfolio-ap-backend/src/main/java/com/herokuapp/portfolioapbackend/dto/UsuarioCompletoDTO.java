/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlos
 */
@Getter @Setter
public class UsuarioCompletoDTO extends UsuarioDTO {
    
    private String password;
    private String privilegios;
    private String ultimoAcceso;
    private String fechaNacimiento;
    
}
