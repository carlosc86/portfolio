import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EstudioData } from '../components/estudioData';
import { ApiComunicationService } from './api-comunication.service';

@Injectable({
  providedIn: 'root'
})
export class EstudioDataService {

  private endpointRoot:string="/estudios"

  constructor(private api:ApiComunicationService) { }

  traerEstudios():Observable<EstudioData[]>{
    return this.api.getUrl(this.endpointRoot);
  }

  modificarEstudio(estudio:EstudioData){
    console.log(this.endpointRoot+"/"+estudio.id);
    return this.api.putUrl(this.endpointRoot+"/"+estudio.id,estudio);
  }

  agregarEstudio(estudio:EstudioData){
    return this.api.postUrl(this.endpointRoot,estudio);
  }

  borrarEstudio(estudio:EstudioData){
    return this.api.deleteUrl(this.endpointRoot+"/"+estudio.id);
  }
}
