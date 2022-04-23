import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HabilidadData } from '../components/habilidadData';
import { ApiComunicationService } from './api-comunication.service';
import { DataService } from './dataService';

@Injectable({
  providedIn: 'root'
})
export class HabilidadDataService extends DataService<HabilidadData> {

  protected override endpointRoot:string=environment.endpoint_habilidades;

  constructor(protected override api:ApiComunicationService) {
      super(api);
   }


}
