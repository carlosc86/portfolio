import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { EstudioData } from '../estudioData';

@Component({
  selector: 'app-info-estudio',
  templateUrl: './info-estudio.component.html',
  styleUrls: ['./info-estudio.component.css']
})
export class InfoEstudioComponent implements OnInit {

  @Input() estudio:EstudioData={
    id:0,
    titulo:"",
    institucion:"",
    urlLogo:"",
    anioInicio:"",
    anioFin:""
  };

  @Output() emisor:EventEmitter<EstudioData>=new EventEmitter<EstudioData>();

  constructor() { }

  ngOnInit(): void {
  }

  buscarEditor(){
    this.emisor.emit(this.estudio);
  }

}
