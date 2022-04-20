import { Component, OnInit } from '@angular/core';
import { MedioContactoData, mediosContacto } from '../medioContactoData';

@Component({
  selector: 'app-barra-menu',
  templateUrl: './barra-menu.component.html',
  styleUrls: ['./barra-menu.component.css']
})
export class BarraMenuComponent implements OnInit {

  usuario:string="Carlos";
  mediosContacto:MedioContactoData[]=mediosContacto;

  constructor() { }

  ngOnInit(): void {
  }

  isLogin(){
    return this.usuario.length>0;
  }

}
