import { Component, OnInit,Input, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { SeccionData } from '../seccionData';


@Component({
  selector: 'app-seccion',
  templateUrl: './seccion.component.html',
  styleUrls: ['./seccion.component.css']
})
export class SeccionComponent implements OnInit {

  @Input() seccion:SeccionData={
    id:NaN,
    nombre:"",
    titulo:"",
    texto:"",
    urlImagen:""
  };

  @Output() activar:EventEmitter<SeccionData>=new EventEmitter<SeccionData>();

  constructor() {
    
   }

  ngOnInit(): void {
  }

  llamarEditor(){
    this.activar.emit(this.seccion);
  }

}
