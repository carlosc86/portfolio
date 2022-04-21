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

  estudio:EstudioData={
    id:NaN,
    titulo:"",
    institucion:"",
    urlLogo:"",
    anioInicio:"",
    anioFin:""
  };
   estudios:EstudioData[]=[];

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
    this.estudioService.traerEstudios().subscribe(dato=>{
      this.estudios=dato;
    });
  }

  //Cambiar esto por binding directo
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
        this.estudioService.agregarEstudio(this.estudio).subscribe(dato=>{
          this.estudio.id=dato.id;
          this.estudios.push(this.estudio);
          this.resetForm();
        });  
    }      
    else{
      this.estudioService.modificarEstudio(this.estudio).subscribe(dato=>{
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
    
  }
  
  setActivo($event:EstudioData){
    this.estudio=$event;
  }

  eliminarEstudio(){
    this.estudioService.borrarEstudio(this.estudio).subscribe(dato=>{
      let indice=this.estudios.indexOf(this.estudio);
      this.estudios.splice(indice,1);
    });
  }

}
