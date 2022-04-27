import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { MedioContactoData} from '../components/medioContactoData';
import { ApiComunicationService } from './api-comunication.service';
import { DataService } from './dataService';

@Injectable({
  providedIn: 'root'
})
export class MedioContactoDataService extends DataService<MedioContactoData> {
  protected override endpointRoot: string=environment.endpoint_medios_contacto;
  constructor(protected override api:ApiComunicationService) {
    super(api);
   }
}
