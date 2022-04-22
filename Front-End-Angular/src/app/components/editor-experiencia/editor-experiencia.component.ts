import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ExperienciaDataService } from 'src/app/services/experiencia-data.service';
import { ExperienciaData } from '../experienciaData';

@Component({
  selector: 'app-editor-experiencia',
  templateUrl: './editor-experiencia.component.html',
  styleUrls: ['./editor-experiencia.component.css']
})
export class EditorExperienciaComponent implements OnInit {

  experiencias:ExperienciaData[]=[];

  experiencia:ExperienciaData={
    id:NaN,
    puesto:"",
    tipoTrabajo:"",
    descripcion:"",
    nombreEmpresa:"",
    urlLogoEmpresa:"",
    fechaInicio:"",
    fechaFin:""
  };

  copia:ExperienciaData={
    id:NaN,
    puesto:"",
    tipoTrabajo:"",
    descripcion:"",
    nombreEmpresa:"",
    urlLogoEmpresa:"",
    fechaInicio:"",
    fechaFin:""
  };

  forms:FormGroup;

  constructor(private fb:FormBuilder,
              private experienciaService:ExperienciaDataService) { 
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
    this.experienciaService.traer<ExperienciaData>().subscribe(dato=>{
      this.experiencias=dato;
    });
  }

  cancelar(){
    this.experiencia.puesto=this.copia.puesto;
    this.experiencia.tipoTrabajo=this.copia.tipoTrabajo;
    this.experiencia.descripcion=this.copia.descripcion;
    this.experiencia.nombreEmpresa=this.copia.nombreEmpresa;
    this.experiencia.urlLogoEmpresa=this.copia.urlLogoEmpresa;
    this.experiencia.fechaInicio=this.copia.fechaInicio;
    this.experiencia.fechaFin=this.copia.fechaFin;

    this.resetForm();

  }

  resetForm(){
    this.experiencia={
      id:NaN,
      puesto:"",
      tipoTrabajo:"",
      descripcion:"",
      nombreEmpresa:"",
      urlLogoEmpresa:"",
      fechaInicio:"",
      fechaFin:""
    };
    this.forms.reset();
  }

  aceptar(){
    this.experiencia.puesto=this.forms.value.puesto;
    this.experiencia.tipoTrabajo=this.forms.value.tipoTrabajo;
    this.experiencia.descripcion=this.forms.value.descripcion;
    this.experiencia.nombreEmpresa=this.forms.value.nombreEmpresa;
    this.experiencia.urlLogoEmpresa=this.forms.value.urlLogoEmpresa;
    this.experiencia.fechaInicio=this.forms.value.fechaInicio;
    this.experiencia.fechaFin=this.forms.value.fechaFin;
    if(isNaN(this.experiencia.id))
      this.experienciaService.agregar<ExperienciaData>(this.experiencia).subscribe(dato=>{
        this.experiencia.id=dato.id;
        this.experiencias.push(this.experiencia);
        this.resetForm();
      });
    else
      this.experienciaService.modificar<ExperienciaData>(this.experiencia).subscribe(dato=>{
        this.resetForm();
      });
  }


  setActivo(experiencia:ExperienciaData){
    this.experiencia=experiencia;

    this.copia.puesto=experiencia.puesto;
    this.copia.tipoTrabajo=experiencia.tipoTrabajo;
    this.copia.nombreEmpresa=experiencia.nombreEmpresa;
    this.copia.urlLogoEmpresa=experiencia.urlLogoEmpresa;
    this.copia.descripcion=experiencia.descripcion;
    this.copia.fechaInicio=experiencia.fechaInicio;
    this.copia.fechaFin=experiencia.fechaFin;
  }

  eliminarExperiencia(){
    this.experienciaService.borrar<ExperienciaData>(this.experiencia).subscribe(dato=>{
      let indice=this.experiencias.indexOf(this.experiencia);
      this.experiencias.splice(indice,1);
    });

  }

}
