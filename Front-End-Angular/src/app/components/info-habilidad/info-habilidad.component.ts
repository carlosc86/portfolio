import { Component, Input, OnInit } from '@angular/core';
import { HabilidadData } from '../habilidadData';

@Component({
  selector: 'app-info-habilidad',
  templateUrl: './info-habilidad.component.html',
  styleUrls: ['./info-habilidad.component.css']
})
export class InfoHabilidadComponent implements OnInit {

  @Input() habilidad:HabilidadData={
    id:-1,
    nombre:"",
    descripcion:"",
    porcentaje:-1
  }

  constructor() { }

  ngOnInit(): void {
  }

}
