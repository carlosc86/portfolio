import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { CredencialData } from '../components/credencialData';
import { ApiComunicationService } from './api-comunication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  currentUserSubject:BehaviorSubject<any>;
  private endpointRoot=environment.endpoint_autorizacion;
  private tokenName=environment.sessionTokenName;

  constructor(private api:ApiComunicationService) { 
    this.currentUserSubject=new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem(this.tokenName)||'{}'));
  }

  login(credenciales:CredencialData):Observable<any>{
    //CAMBIAR ESTO POR UN POST
    return this.api.getUrl(this.endpointRoot/*,credenciales*/).pipe(map(data=>{
      sessionStorage.setItem(this.tokenName,JSON.stringify(data));//guardo el token en el sessionStorage.
      this.currentUserSubject.next(JSON.parse(sessionStorage.getItem(this.tokenName)!));
      return data;
    }));
  }

  logout():Observable<any>{
    return this.api.getUrl(this.endpointRoot).pipe(map(data=>{
      sessionStorage.removeItem(this.tokenName);
      this.currentUserSubject.next(JSON.parse('{}'));//no hay nada lo acabo de borrar
      return data;
    }));
  }

  isLogin():boolean{
    return sessionStorage.getItem(this.tokenName)? true:false; //Por ahora si no hay token no estas logueado, sin tener en cuenta la expiracion.
  }

  get usuarioAutenticado(){
    return this.currentUserSubject.value;
  }
}
