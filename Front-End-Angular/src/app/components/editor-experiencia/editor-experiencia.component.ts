import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExperienciaData } from '../experienciaData';

@Component({
  selector: 'app-editor-experiencia',
  templateUrl: './editor-experiencia.component.html',
  styleUrls: ['./editor-experiencia.component.css']
})
export class EditorExperienciaComponent implements OnInit {

  @Input() experiencia:ExperienciaData={
    id:-1,
    puesto:"",
    tipoTrabajo:"",
    descripcion:"",
    nombreEmpresa:"",
    urlLogoEmpresa:"",
    fechaInicio:"",
    fechaFin:""
  };

  @Output() cambiar:EventEmitter<ExperienciaData>=new EventEmitter<ExperienciaData>();
  @Output() agregar:EventEmitter<ExperienciaData>=new EventEmitter<ExperienciaData>();

  forms:FormGroup;

  constructor(private fb:FormBuilder) { 
    this.forms=fb.group({
      puesto:[''],
      tipoTrabajo:[''],
      descripcion:[''],
      nombreEmpresa:[''],
      urlLogoEmpresa:[''],
      fechaInicio:[''],
      fechaFin:['']
    });
  }

  ngOnInit(): void {
  }

  precargar(){
    this.forms.setValue({
      puesto:this.experiencia.puesto,
      tipoTrabajo:this.experiencia.tipoTrabajo,
      descripcion:this.experiencia.descripcion,
      nombreEmpresa:this.experiencia.nombreEmpresa,
      urlLogoEmpresa:this.experiencia.urlLogoEmpresa,
      fechaInicio:this.experiencia.fechaInicio,
      fechaFin:this.experiencia.fechaFin
    });

  }

  resetear(){
    this.experiencia={
      id:-1,
      puesto:"",
      tipoTrabajo:"",
      descripcion:"",
      nombreEmpresa:"",
      urlLogoEmpresa:"",
      fechaInicio:"",
      fechaFin:""
    };
    this.forms.reset();
    this.cambiar.emit(this.experiencia);
  }

  aceptar(){
    this.experiencia.puesto=this.forms.value.puesto;
    this.experiencia.tipoTrabajo=this.forms.value.tipoTrabajo;
    this.experiencia.descripcion=this.forms.value.descripcion;
    this.experiencia.nombreEmpresa=this.forms.value.nombreEmpresa;
    this.experiencia.urlLogoEmpresa=this.forms.value.urlLogoEmpresa;
    this.experiencia.fechaInicio=this.forms.value.fechaInicio;
    this.experiencia.fechaFin=this.forms.value.fechaFin;
    if(this.experiencia.id>=0)
      this.cambiar.emit(this.experiencia);
    else
      this.agregar.emit(this.experiencia);
  }

}
