/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase que funciona como soporte para la fachada, contiene datos de configuracion del servicio
 * @author carlos
 */
@Getter @Setter
@Component
public class JwtConfig {
    @Value("${portfolio.jwt.issuer}")
    private String issuer;
    
    @Value("${portfolio.jwt.expire-time}")
    private long expireTime;
    
    @Value("${portfolio.jwt.key}")
    private String key; 
}
