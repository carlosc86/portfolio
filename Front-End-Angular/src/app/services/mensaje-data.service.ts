import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { MensajeData } from '../components/mensajeData';
import { ApiComunicationService } from './api-comunication.service';
import { DataService } from './dataService';

@Injectable({
  providedIn: 'root'
})
export class MensajeDataService extends DataService<MensajeData> {

  protected override endpointRoot: string=environment.endpoint_mensajes;

  constructor(protected override api:ApiComunicationService) {
    super(api);
   }
}
