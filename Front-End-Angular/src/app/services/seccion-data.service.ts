import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable, of } from 'rxjs';

import { ApiComunicationService } from './api-comunication.service';
import { SeccionData } from '../components/seccionData';

@Injectable({
  providedIn: 'root'
})
export class SeccionDataService {

  private endpointRoot:string='/secciones'

  constructor(private api:ApiComunicationService) { }

  //Obtener seccion por el nombre
  traerSeccionPorNombre(nombre:string):Observable<SeccionData[]>{
    return this.api.getUrl(this.endpointRoot+"?nombre="+nombre);
  }

  //Modificar una seccion
  modificarSeccion(seccion:SeccionData):Observable<any>{
    return this.api.putUrl(this.endpointRoot,seccion);
  }
}
