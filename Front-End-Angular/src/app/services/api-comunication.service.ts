import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpRequest } from '@angular/common/http';
import { catchError, Observable, of, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiComunicationService {

  constructor(private http:HttpClient) { }
  private errorHandler(error:HttpErrorResponse){
    if(error.status===0){
      console.log("Error de conexion: No se ha podido establecer una comunicacion con el servidor.")
    }else{
      console.error(`Ha ocurrido un error!!\nCodigo: ${error.status} \nError: ${error.error}`);
    }
    return throwError(()=>new Error("Error en la comunicacion con API, vuelva a intentarlo o comuniquese con el administrador."));

  }

  getUrl(endpoint:string):Observable<any>{
    return this.http.get<any>(environment.urlServicio+endpoint)
                    .pipe(catchError(this.errorHandler));
  }
  putUrl(endpoint:string,body:any):Observable<any>{
    return this.http.put(environment.urlServicio+endpoint,body)
                    .pipe(catchError(this.errorHandler));
  }
  postUrl(endpoint:string,body:any,header?:HttpHeaders):Observable<any>{
    return this.http.post(environment.urlServicio+endpoint,body,{'headers':header})
                    .pipe(catchError(this.errorHandler));
  }
  deleteUrl(endpoint:string):Observable<any>{
    return this.http.delete(environment.urlServicio+endpoint)
                    .pipe(catchError(this.errorHandler));
  }


}
