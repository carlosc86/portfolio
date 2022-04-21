import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HabilidadData } from '../components/habilidadData';
import { ApiComunicationService } from './api-comunication.service';

@Injectable({
  providedIn: 'root'
})
export class HabilidadDataService {

  private endpointRoot:string="/habilidades"

  constructor(private api:ApiComunicationService) { }

  traerHabilidades():Observable<HabilidadData[]>{
    return this.api.getUrl(this.endpointRoot);
  }

  agregarHabilidad(habilidad:HabilidadData){
    return this.api.postUrl(this.endpointRoot,habilidad);
  }

  modificarHabilidad(habilidad:HabilidadData){
    return this.api.putUrl(this.endpointRoot+"/"+habilidad.id,habilidad);
  }

  borrarHabilidad(habilidad:HabilidadData){
    return this.api.deleteUrl(this.endpointRoot+"/"+habilidad.id);
  }

}
