import { Component, OnInit } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { SeccionDataService } from 'src/app/services/seccion-data.service';
import { SeccionData } from '../seccionData';


@Component({
  selector: 'app-seccion',
  templateUrl: './seccion.component.html',
  styleUrls: ['./seccion.component.css']
})
export class SeccionComponent implements OnInit {

  public seccion:SeccionData={
    id:-1,
    nombre:"",
    titulo:"",
    texto:"",
    urlImagen:""
  };

  llamada:EventEmitter<SeccionData>=new EventEmitter<SeccionData>();

  constructor() {
    
   }

  ngOnInit(): void {
  }

  editarSeccion($event:SeccionData){
    this.seccion=$event;
  }

  llamarEditor(){

  }

}
