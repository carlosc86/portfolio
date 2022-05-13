/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.herokuapp.portfolioapbackend.exceptions.TokenInvalidException;
import com.herokuapp.portfolioapbackend.exceptions.TokenSignatureInvalidException;
import com.herokuapp.portfolioapbackend.exceptions.TokenTimeExpiredException;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fachada para la libreria jwt (auth-0)
 * @author carlos
 */
@Service
public class JwtService {
    
    private final String BEARER="bearer ";
    private final String USUARIO="usuario";
    private final String PRIVILEGIOS="privilegios";
    
    
    @Autowired
    private JwtConfig jwtConfig;
    
    /*Metodo que crea un nuevo token valido, por tiempo limitado*/
    public String createToken(String nombreUsuario, String privilegios) throws Exception{
        return JWT.create()//coloca automaticamente la cabecera
                //Coloco los datos del payload
                .withIssuer(jwtConfig.getIssuer()) 
                .withClaim(USUARIO, nombreUsuario)
                //.withClaim(PRIVILEGIOS, privilegios) //Datos sensibles
                .withExpiresAt(new Date(System.currentTimeMillis()+jwtConfig.getExpireTime()))
                //Lo firmo con la clave
                .sign(Algorithm.HMAC256(jwtConfig.getKey()));
    }
    
    
    /*Compruebo si la cadena de autorizacion (Header Http) contiene el formato necesario*/
    public boolean isBearer(String token){
        return (token!=null)&&(token.toLowerCase().startsWith(BEARER))&&((token.split("\\.").length)==3);
    }
    
    /*Verifico si el token es valido*/
    public boolean verifyAuth(String auth) throws Exception{
        String token=getToken(auth);
        boolean retorno=true;
        try {
            JWTVerifier verificador = JWT.require(Algorithm.HMAC256(jwtConfig.getKey()))
                    .withIssuer(jwtConfig.getIssuer())//Comprueba quien emitio el token
                    .acceptExpiresAt(0)//Compruebo si se paso del tiempo de expiracion
                    .build();
            DecodedJWT jwt=verificador.verify(token);
            /*Para conocer el tiempo de vida restante del token*/
            /*
            Date ahora=new Date(System.currentTimeMillis());
            Date tiempoT=jwt.getExpiresAt();
            long tiempo=tiempoT.getTime()-ahora.getTime();
            Duration d=Duration.ofMillis(tiempo);
            System.out.println("Tiempo de vida restante del token: "+d.toMinutesPart()+":"+d.toSecondsPart());
            */
            retorno= true;
        }catch(SignatureVerificationException ex){//Compruebo si la firma es valida
            throw new TokenSignatureInvalidException();
        }catch (TokenExpiredException ex){//Compruebo si el token expiró
            throw new TokenTimeExpiredException();
        } catch (JWTVerificationException ex) { //Compruebo si tiene el formato que corresponde
            throw new TokenInvalidException(ex.getMessage());
        }        
        return retorno;
    }
    
    //Separa el token de la cabecera de authorizacion de la solicitud http
    public String getToken(String auth){
        if(isBearer(auth)) return auth.substring(BEARER.length());
        else return auth;
    }
    
    //Obtiene el usuario de un token valido
    public String getTokenUser(String token){
        String usuario=null;
        try {
            usuario= JWT.require(Algorithm.HMAC256(jwtConfig.getKey())).build()
                    .verify(token).getClaim(USUARIO).asString();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(JwtService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    //Obtiene los privilegios de un token valido
    public String getTokenPrivileges(String token){
        String privilegios=null;
        try {
            privilegios= JWT.require(Algorithm.HMAC256(jwtConfig.getKey())).build()
                    .verify(token).getClaim(PRIVILEGIOS).as(String.class);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(JwtService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return privilegios;
    }
}
