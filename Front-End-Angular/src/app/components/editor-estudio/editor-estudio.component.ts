import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EstudioData } from '../estudioData';

@Component({
  selector: 'app-editor-estudio',
  templateUrl: './editor-estudio.component.html',
  styleUrls: ['./editor-estudio.component.css']
})
export class EditorEstudioComponent implements OnInit {

  @Input() estudio:EstudioData={
    id:-1,
    titulo:"",
    institucion:"",
    urlLogo:"",
    anioInicio:"",
    anioFin:""
  };
  @Output() cambiar:EventEmitter<EstudioData>=new EventEmitter<EstudioData>();
  @Output() agregar:EventEmitter<EstudioData>=new EventEmitter<EstudioData>();

  forms:FormGroup;

  constructor(private fb:FormBuilder) {
    this.forms=fb.group({
      titulo:[''],
      institucion:[''],
      urlLogo:[''],
      anioInicio:[''],
      anioFin:['']
    });
   }

  ngOnInit(): void {
  }

  precargarDatos(){
    this.forms.setValue({
      titulo:this.estudio.titulo,
      institucion:this.estudio.institucion,
      urlLogo:this.estudio.urlLogo,
      anioInicio:this.estudio.anioInicio,
      anioFin:this.estudio.anioFin
    });
  }

  submit(){
    this.estudio.titulo=this.forms.value.titulo;
    this.estudio.institucion=this.forms.value.institucion;
    this.estudio.urlLogo=this.forms.value.urlLogo;
    this.estudio.anioInicio=this.forms.value.anioInicio;
    this.estudio.anioFin=this.forms.value.anioFin;
    //Llamar al servicio Api para guardar 
    if(this.estudio.id>=0)
      this.cambiar.emit(this.estudio);
    else
      this.agregar.emit(this.estudio);
  }
  cancelar(){
    this.resetForm();
  }

  resetForm(){
    this.estudio={
      id:-1,
      titulo:"",
      institucion:"",
      urlLogo:"",
      anioInicio:"",
      anioFin:""
    };
    this.forms.reset();    
    this.cambiar.emit(this.estudio);
  }

}
