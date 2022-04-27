import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ProyectoData } from '../components/proyectoData';
import { ApiComunicationService } from './api-comunication.service';
import { DataService } from './dataService';

@Injectable({
  providedIn: 'root'
})
export class ProyectoDataService extends DataService<ProyectoData> {

  protected override endpointRoot: string=environment.endpoint_proyectos;

  constructor(protected override api:ApiComunicationService) { 
    super(api);

  }
}
