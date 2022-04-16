import { Component, OnInit } from '@angular/core';
import { Input, Output, EventEmitter } from '@angular/core';
import { SeccionData } from '../seccionData';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-editar-seccion',
  templateUrl: './editar-seccion.component.html',
  styleUrls: ['./editar-seccion.component.css']
})
export class EditarSeccionComponent implements OnInit {

  @Input() seccion:SeccionData=new SeccionData;
  
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
