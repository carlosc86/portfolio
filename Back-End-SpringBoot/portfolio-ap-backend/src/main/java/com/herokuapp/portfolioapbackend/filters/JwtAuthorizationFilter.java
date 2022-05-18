/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.filters;

import com.herokuapp.portfolioapbackend.exceptions.TokenInvalidException;
import com.herokuapp.portfolioapbackend.exceptions.TokenSignatureInvalidException;
import com.herokuapp.portfolioapbackend.exceptions.TokenTimeExpiredException;
import com.herokuapp.portfolioapbackend.security.JwtService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Filtro para validar las peticiones que tienen el token jwt, si el token es valido
 * el filtro lo deja pasar sino lo bloquea y envia un mensaje de error 401.
 * @author carlos
 */
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter{
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String auth=request.getHeader("authorization");
        if(jwtService.isBearer(auth)){  //Me fijo si tiene token
            try {             
                if(jwtService.verifyAuth(auth)){//Compruebo si es valido  
                    String username=jwtService.getTokenUser(jwtService.getToken(auth)); //Obtengo el nombre de usuario del token
                    UserDetails user=userDetailsService.loadUserByUsername(username);//Obtengo los demas datos de la db      
                    UsernamePasswordAuthenticationToken authentication= 
                            new UsernamePasswordAuthenticationToken(user.getUsername(), null,user.getAuthorities());//Creo la autorizacion
                    SecurityContextHolder.getContext().setAuthentication(authentication);//La registro en la seguridad del server
                }
            } catch (TokenInvalidException | TokenTimeExpiredException | TokenSignatureInvalidException ex) {              
               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               response.addHeader("Error", ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(JwtAuthorizationFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);//Paso al siguiente filtro.
    }
}
