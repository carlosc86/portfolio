import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, of, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiComunicationService {

  constructor(private http:HttpClient) { }

  /*private errorHandler<T>(operacion = 'llamada',resultado?:T){
    return (error:any)=>{
      console.log("No se pudo procesar "+operacion+" : "+error);
      // Let the app keep running by returning an empty result.
      return of(resultado as T);
    }
  }*/

  private errorHandler(error:HttpErrorResponse){
    if(error.status===0){
      console.log("Error de conexion: No se ha podido establecer una comunicacion con el servidor.")
    }else{
      console.error(`Ha ocurrido un error!!\nCodigo: ${error.status} \nBody: ${error.error}`);
    }
    return throwError(()=>new Error("Error en la comunicacion con API, vuelva a intentarlo o comuniquese con el administrador."));

  }

  getUrl(endpoint:string):Observable<any>{
    return this.http.get<any>(environment.urlServicio+endpoint)
                    .pipe(catchError(this.errorHandler));
  }
  putUrl(endpoint:string,body:any):Observable<any>{
    return this.http.put(environment.urlServicio+endpoint+"/"+body.id,body)
                    .pipe(catchError(this.errorHandler));
  }
  postUrl(endpoint:string,body:any):Observable<any>{
    return this.http.post(environment.urlServicio+endpoint,body)
                    .pipe(catchError(this.errorHandler));
  }
  deleteUrl(endpoint:string,body:any):Observable<any>{
    return this.http.delete(environment.urlServicio+endpoint,body)
                    .pipe(catchError(this.errorHandler));
  }


}
