import { Component, OnInit } from '@angular/core';
import { Input, Output, EventEmitter } from '@angular/core';
import { Seccion } from '../seccion';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-editar-seccion',
  templateUrl: './editar-seccion.component.html',
  styleUrls: ['./editar-seccion.component.css']
})
export class EditarSeccionComponent implements OnInit {

  @Input() seccion:Seccion=new Seccion;
  @Input() tituloS:string="";
  @Output() messageEvent:EventEmitter<Seccion>=new EventEmitter<Seccion>();
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

  getTituloSeccion():string{
    return this.tituloS;
  }

  aceptar(){
    this.seccion.setTitulo(this.forms.value.titulo);
    this.seccion.setTexto(this.forms.value.texto);
    this.seccion.setUrlImagen(this.forms.value.urlImagen)
    this.messageEvent.emit(this.seccion);
    this.forms.reset();
  }

  cancelar(){
    this.forms.reset();
  }


}
