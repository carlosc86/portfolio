import { Component,  OnInit,  } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HabilidadDataService } from 'src/app/services/habilidad-data.service';
import { HabilidadData } from '../habilidadData';

@Component({
  selector: 'app-editor-habilidad',
  templateUrl: './editor-habilidad.component.html',
  styleUrls: ['./editor-habilidad.component.css']
})
export class EditorHabilidadComponent implements OnInit {

  habilidad:HabilidadData={
    id:NaN,
    nombre:"",
    descripcion:"",
    porcentaje:50
  };
  private copia:HabilidadData={
    id:NaN,
    nombre:"",
    descripcion:"",
    porcentaje:50
  };

  habilidades:HabilidadData[]=[];
  
  forms:FormGroup;

  constructor(private fb:FormBuilder,
              private habilidadService:HabilidadDataService) {
    this.forms=fb.group({
      nombre:[''],
      descripcion:[''],
      porcentaje:[50]
    });
   }

  ngOnInit(): void {
    this.habilidadService.traerHabilidades().subscribe(datos=>{
      this.habilidades=datos;
    });
  }

  resetForm(){
    this.habilidad={
      id:NaN,
      nombre:"",
      descripcion:"",
      porcentaje:50
    };
    this.forms.reset();
  }

  aceptar(){
    this.habilidad.nombre=this.forms.value.nombre;
    this.habilidad.descripcion=this.forms.value.descripcion;
    this.habilidad.porcentaje=this.forms.value.porcentaje;
    if(isNaN(this.habilidad.id))
      this.habilidadService.agregarHabilidad(this.habilidad).subscribe(dato=>{
        this.habilidad.id=dato.id;
        this.habilidades.push(this.habilidad);
        this.resetForm();
      });
    else  
      this.habilidadService.modificarHabilidad(this.habilidad).subscribe(dato=>{
        this.resetForm();
      });
  }

  cancelar(){
    this.habilidad.nombre=this.copia.nombre;
    this.habilidad.descripcion=this.copia.descripcion;
    this.habilidad.porcentaje=this.copia.porcentaje;
    this.resetForm();
  }

  setActivo(habilidad:HabilidadData){
    this.habilidad=habilidad;
    this.copia.nombre=habilidad.nombre;
    this.copia.descripcion=habilidad.descripcion;
    this.copia.porcentaje=habilidad.porcentaje;
  }

  eliminarHabilidad(){
    this.habilidadService.borrarHabilidad(this.habilidad).subscribe(dato=>{
      let indice=this.habilidades.indexOf(this.habilidad);
      this.habilidades.splice(indice,1);
    });
  }

}
