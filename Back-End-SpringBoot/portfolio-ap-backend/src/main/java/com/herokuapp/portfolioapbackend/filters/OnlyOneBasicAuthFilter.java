/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Filtro que elimina todas las peticiones que tienen Basic auth y que no van al
 * endpoint establecido. (solo permite basic auth en un solo endpoint)
 * @author carlos
 */
//@Component
public class OnlyOneBasicAuthFilter extends OncePerRequestFilter{

    private String ruta;
    
    public OnlyOneBasicAuthFilter(String path) {
        this.ruta=path;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String auth=request.getHeader("authorization");
        String path=request.getRequestURI();
        if((isPath(path)&&!isBasicAuth(auth))||//Si la solicitud es en el endpoint registrado en el filtro, pero no es basic auth
           (!isPath(path)&&isBasicAuth(auth))){//o si la solicitud no es en el endpoint y se quiere acceder con basicAuth 
                setError401(response);
        }else
            filterChain.doFilter(request, response);//Si no hay error sigo con la cadena de filtros.
    }
    
    private boolean isBasicAuth(String auth){
        return auth!=null&&auth.toLowerCase().startsWith("basic");
    }
    
    private  boolean isPath(String path){
        return this.ruta.equalsIgnoreCase(path);
    }
    private void setError401(HttpServletResponse response){
        response.setStatus(401); //Genero una respuesta del tipo 401 - Unauthorized
        response.addHeader("Error", "Imposible utilizar ese metodo de autenticacion.");
    }
    
}
