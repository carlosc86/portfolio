import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ProyectoData } from '../proyectoData';

@Component({
  selector: 'app-info-proyecto',
  templateUrl: './info-proyecto.component.html',
  styleUrls: ['./info-proyecto.component.css']
})
export class InfoProyectoComponent implements OnInit {

  @Input() proyecto:ProyectoData={
    id:-1,
    nombre:"",
    descripcion:"",
    link:"",
    anio:"",
    urlImagenes:[""]
  }

  @Output() emisor:EventEmitter<ProyectoData>=new EventEmitter<ProyectoData>();

  constructor() { }

  ngOnInit(): void {
  }

  buscarEditor(){
    this.emisor.emit(this.proyecto);
  }

}
