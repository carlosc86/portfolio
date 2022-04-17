import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HabilidadData } from '../habilidadData';

@Component({
  selector: 'app-editor-habilidad',
  templateUrl: './editor-habilidad.component.html',
  styleUrls: ['./editor-habilidad.component.css']
})
export class EditorHabilidadComponent implements OnInit {

  @Input() habilidad:HabilidadData={
    id:-1,
    nombre:"",
    descripcion:"",
    porcentaje:50
  };

  @Output() cambiar:EventEmitter<HabilidadData>=new EventEmitter<HabilidadData>();
  @Output() agregar:EventEmitter<HabilidadData>=new EventEmitter<HabilidadData>();

  forms:FormGroup;

  constructor(private fb:FormBuilder) {
    this.forms=fb.group({
      nombre:[''],
      descripcion:[''],
      porcentaje:[50]
    });
   }

  ngOnInit(): void {
  }

  precargar(){
    this.forms.setValue({
      nombre:this.habilidad.nombre,
      descripcion:this.habilidad.descripcion,
      porcentaje:this.habilidad.porcentaje
    });
  }
  resetear(){
    this.forms.reset();
    this.habilidad={
      id:-1,
      nombre:"",
      descripcion:"",
      porcentaje:50
    };
    this.cambiar.emit(this.habilidad);
  }

  aceptar(){
    this.habilidad.nombre=this.forms.value.nombre;
    this.habilidad.descripcion=this.forms.value.descripcion;
    this.habilidad.porcentaje=this.forms.value.porcentaje;
    if(this.habilidad.id>=0)
      this.cambiar.emit(this.habilidad);
    else  
      this.agregar.emit(this.habilidad);
  }

}
