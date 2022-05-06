import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ProyectoData } from '../proyectoData';

@Component({
  selector: 'app-info-proyecto',
  templateUrl: './info-proyecto.component.html',
  styleUrls: ['./info-proyecto.component.css']
})
export class InfoProyectoComponent implements OnInit {

  @Input() proyecto:ProyectoData={
    id:NaN,
    nombre:"",
    descripcion:"",
    link:"",
    fecha:"",
    rutasImagenes:[""]
  }

  @Output() emisor:EventEmitter<ProyectoData>=new EventEmitter<ProyectoData>();

  constructor() { }

  ngOnInit(): void {
  }

  activar(){
    this.emisor.emit(this.proyecto);
  }

  getYear(fecha:String){
    return fecha.split("-")[0];
  }
}
