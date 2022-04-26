import { Component, OnInit } from '@angular/core';
import { MedioContactoDataService } from 'src/app/services/medio-contacto-data.service';
import { MedioContactoData } from '../medioContactoData';

@Component({
  selector: 'app-barra-menu',
  templateUrl: './barra-menu.component.html',
  styleUrls: ['./barra-menu.component.css']
})
export class BarraMenuComponent implements OnInit {
  mediosContacto:MedioContactoData[]=[];
  usuario:string="Carlos";

  constructor(private mediosContactoService:MedioContactoDataService) { }

  ngOnInit(): void {
  }

  isLogin(){
    return this.usuario.length>0;
  }

  cargarLista(medios:MedioContactoData[]){
    this.mediosContacto=medios;
  }

}
