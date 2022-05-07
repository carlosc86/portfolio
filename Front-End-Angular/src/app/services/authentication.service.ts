import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { CredencialData } from '../components/credencialData';
import { UsuarioData } from '../components/usuarioData';
import { ApiComunicationService } from './api-comunication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  currentTokenSubject:BehaviorSubject<any>;
  currentUserSubject:BehaviorSubject<UsuarioData>;
  private endpointRoot=environment.endpoint_autorizacion;
  private tokenKey=environment.sessionTokenName;
  private userKey=environment.sessionUserName;

  constructor(private api:ApiComunicationService) { 
    this.currentTokenSubject=new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem(this.tokenKey)||'{}'));
    this.currentUserSubject=new BehaviorSubject<UsuarioData>(JSON.parse(sessionStorage.getItem(this.userKey)||'{}'));
  }

  login(credenciales:CredencialData):Observable<any>{
    //CAMBIAR ESTO POR UN POST
    let header=new HttpHeaders().set("Authorization","basic "+btoa(credenciales.user+":"+credenciales.password));
    return this.api.postUrl(this.endpointRoot,"",header).pipe(map(data=>{
      sessionStorage.setItem(this.tokenKey,JSON.stringify(data.token));//guardo el token en el sessionStorage.
      sessionStorage.setItem(this.userKey,JSON.stringify(data.usuario));
      this.currentTokenSubject.next(JSON.parse(sessionStorage.getItem(this.tokenKey)!));
      this.currentUserSubject.next(JSON.parse(sessionStorage.getItem(this.userKey)!));
      return data;
    }));
  }

  logout():Observable<any>{
    return this.api.getUrl(this.endpointRoot).pipe(map(data=>{
      sessionStorage.removeItem(this.tokenKey);
      sessionStorage.removeItem(this.userKey);
      this.currentTokenSubject.next(JSON.parse('{}'));//no hay nada lo acabo de borrar
      this.currentUserSubject.next(JSON.parse('{}'));//no hay nada lo acabo de borrar
      return data;
    }));
  }

  isLogin():boolean{
    return sessionStorage.getItem(this.tokenKey)? true:false; //Por ahora si no hay token no estas logueado, sin tener en cuenta la expiracion.
  }

  get tokenUsuario(){
    return this.currentTokenSubject.value;
  }

  get usuario(){
    return this.currentUserSubject.asObservable();
  }
}
