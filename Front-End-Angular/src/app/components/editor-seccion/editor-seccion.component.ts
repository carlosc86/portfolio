import { Component, OnInit } from '@angular/core';
import { Input, Output, EventEmitter } from '@angular/core';
import { SeccionData } from '../seccionData';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-editor-seccion',
  templateUrl: './editor-seccion.component.html',
  styleUrls: ['./editor-seccion.component.css']
})
export class EditorSeccionComponent implements OnInit {

  @Input() seccion:SeccionData={id:0,
                                nombre:"",
                                titulo:"",
                                texto:"",
                                urlImagen:""};
  
  @Output() messageEvent:EventEmitter<SeccionData>=new EventEmitter<SeccionData>();
  forms:FormGroup;

  constructor( private fb:FormBuilder) { 
    this.forms=fb.group({
      titulo:['',],
      urlImagen:['',],
      texto:['',]
    });
  }

  ngOnInit(): void {
  }

  cargarDatos(){
    this.forms.setValue({
      titulo:this.seccion.titulo,
      texto:this.seccion.texto,
      urlImagen:this.seccion.urlImagen
    });
  }

  getTituloSeccion():string{
    return this.seccion.nombre;
  }

  aceptar(){
    this.seccion.titulo=this.forms.value.titulo;
    this.seccion.texto=this.forms.value.texto;
    this.seccion.urlImagen=this.forms.value.urlImagen;
    this.messageEvent.emit(this.seccion);
    this.forms.reset();
  }

  cancelar(){
    this.forms.reset();
  }


}
