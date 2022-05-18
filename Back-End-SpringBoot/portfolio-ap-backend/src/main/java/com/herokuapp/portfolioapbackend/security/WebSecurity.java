/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.security;

import com.herokuapp.portfolioapbackend.filters.JwtAuthorizationFilter;
import com.herokuapp.portfolioapbackend.filters.OnlyOneBasicAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Clase de configuracion de los servicios de spring security
 * @author carlos
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurity extends WebSecurityConfigurerAdapter{
    
    /*Path en donde se debe hacer uso de la autenticacion por basic auth*/
    private final String LOGIN_PATH="/auth";
    
    @Autowired
    private UserDetailsService userService;
    @Autowired
    private JwtAuthorizationFilter jwtFilter;
    
    /* Filtro para bloquear basic auth en cualquier endpoint que no sea el establecido,
     * en esos se utilizara autenticacion por jwt
    */
    private OnlyOneBasicAuthFilter basicFilter =new OnlyOneBasicAuthFilter(LOGIN_PATH);
    
    protected void configure(HttpSecurity http) throws Exception{
        /*Configuracion general de la seguridad*/
        http.csrf().disable() //Deshabilito csrf, tambien deshabilito cors
                .cors().and()
            
                .httpBasic() //Tipo de authenticacion basic
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //No guardo sesiones de usuario en el servidor
                /*Configuracion de la seguridad en los endpoints*/
                .and().authorizeHttpRequests().antMatchers(LOGIN_PATH).authenticated() //Ruta de login, solo con auth basic
                .antMatchers("/portfolio").permitAll()//Portfolio se accede sin autorizacion.
                .antMatchers(HttpMethod.POST,"/mensajes").permitAll()//Endpoint para dejar mensajes al propietario del portfolio, se permite el acceso sin autenticacion.
                .anyRequest().authenticated()//Las demas solo con autorizacion, en realidad las frenara el filtro jwt
                /*Configuracion de filtros*/
                .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)//Agrego el filtro de token
                .addFilterBefore(basicFilter, jwtFilter.getClass())//Agrego el filtro de basic auth
                ;
    }
    
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(getPasswordEncoder());//agrego el servicio de usuarios de spring y el codificador de claves
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
