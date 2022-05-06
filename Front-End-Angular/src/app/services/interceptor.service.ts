import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { isEmpty, Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';
import { isNull } from '@angular/compiler/src/output/output_ast';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor {

  constructor(private authService:AuthenticationService) { }

  
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      let currentToken=this.authService.tokenUsuario;
      if(typeof(currentToken)===typeof ("") ){
        req=req.clone({
          setHeaders:{
            Authorization:`Bearer ${currentToken}`
            
          }
        });
      }
      
      return next.handle(req);
  }
}
