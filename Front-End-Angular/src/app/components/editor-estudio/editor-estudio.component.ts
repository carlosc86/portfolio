import { ThisReceiver } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EstudioDataService } from 'src/app/services/estudio-data.service';
import { EstudioData } from '../estudioData';

@Component({
  selector: 'app-editor-estudio',
  templateUrl: './editor-estudio.component.html',
  styleUrls: ['./editor-estudio.component.css']
})
export class EditorEstudioComponent implements OnInit {

  @Input() estudio:EstudioData={
    id:NaN,
    titulo:"",
    institucion:"",
    urlLogo:"",
    anioInicio:"",
    anioFin:""
  };
  @Output() cambiar:EventEmitter<EstudioData>=new EventEmitter<EstudioData>();
  @Output() agregar:EventEmitter<EstudioData>=new EventEmitter<EstudioData>();

  forms:FormGroup;

  constructor(private fb:FormBuilder,
              private estudioService:EstudioDataService) {
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
    if(isNaN(this.estudio.id)){
      this.estudioService.agregarEstudio(this.estudio).subscribe(data=>{
        this.agregar.emit(this.estudio);
        this.resetForm();
      });      
    }      
    else{
      this.estudioService.modificarEstudio(this.estudio).subscribe(data=>{
        this.cambiar.emit(this.estudio);
        this.resetForm();
      });
      
    }      
  }
  cancelar(){
    this.resetForm();
  }

  resetForm(){
    this.estudio={
      id:NaN,
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
