import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ProyectoData } from '../proyectoData';

@Component({
  selector: 'app-editor-proyecto',
  templateUrl: './editor-proyecto.component.html',
  styleUrls: ['./editor-proyecto.component.css']
})
export class EditorProyectoComponent implements OnInit {

  @Input() proyecto:ProyectoData={
    id:-1,
    nombre:"",
    descripcion:"",
    link:"",
    anio:"",
    urlImagenes:[""]
  };
  listaRutas:string[]=[];

  @Output() cambiar:EventEmitter<ProyectoData>=new EventEmitter<ProyectoData>();
  @Output() agregar:EventEmitter<ProyectoData>=new EventEmitter<ProyectoData>();

  forms:FormGroup;
  
  constructor(private fb:FormBuilder) {
    this.forms=fb.group({
      nombre:[''],
      descripcion:[''],
      link:[''],
      anio:[''],
      urlImagen:[''] //CUIDADO ACA SE DEBE INGRESAR UN ARRAY
    });
   }

  ngOnInit(): void {
  }

  precargar(){
    this.forms.setValue({
      nombre:this.proyecto.nombre,
      descripcion:this.proyecto.descripcion,
      link:this.proyecto.link,
      anio:this.proyecto.anio,
      urlImagen:""
    });
    this.listaRutas=this.proyecto.urlImagenes;

  }

  resetear(){
    this.proyecto={
      id:-1,
      nombre:"",
      descripcion:"",
      link:"",
      anio:"",
      urlImagenes:[]
    };
    this.listaRutas=[];
    this.forms.reset();
    this.cambiar.emit(this.proyecto);
  }

  aceptar(){
    this.proyecto.nombre=this.forms.value.nombre;
    this.proyecto.descripcion=this.forms.value.descripcion;
    this.proyecto.link=this.forms.value.link;
    this.proyecto.anio=this.forms.value.anio;
    this.proyecto.urlImagenes=this.listaRutas;
    if(this.proyecto.id>-1)
      this.cambiar.emit(this.proyecto);
    else
      this.agregar.emit(this.proyecto);

  }

  agregarALista(){
    this.listaRutas.push(this.forms.value.urlImagen);
    this.forms.get('urlImagen')!.setValue('');
  }

  quitarDeLista(ruta:string){
    let indice:number=this.listaRutas.indexOf(ruta);
    if(indice>-1){
      this.listaRutas.splice(indice,1);
    }
  }

}
