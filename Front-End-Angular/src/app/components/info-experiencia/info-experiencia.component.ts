import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ExperienciaData } from '../experienciaData';

@Component({
  selector: 'app-info-experiencia',
  templateUrl: './info-experiencia.component.html',
  styleUrls: ['./info-experiencia.component.css']
})
export class InfoExperienciaComponent implements OnInit {

  @Input() experiencia:ExperienciaData={
    id:NaN,
    puesto:"",
    tipoTrabajo:"",
    descripcion:"",
    nombreEmpresa:"",
    urlLogoEmpresa:"",
    fechaInicio:"",
    fechaFin:""
  };

  @Output() emisor:EventEmitter<ExperienciaData>=new EventEmitter<ExperienciaData>();

  constructor() { }

  ngOnInit(): void {
  }

  activar(){
    this.emisor.emit(this.experiencia);
  }

}
