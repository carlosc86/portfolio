import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor {

  constructor(private authService:AuthenticationService) { }

  
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      let currentUser=this.authService.usuarioAutenticado;
      if(currentUser&&currentUser.accessToken){
        req=req.clone({
          setHeaders:{
            Authorization:`Bearer ${currentUser.accessToken}`
          }
        });
      }
      console.log("Interceptado y enviado")
      return next.handle(req);
  }
}
