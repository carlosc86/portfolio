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

  private copia:EstudioData={
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

  aceptar(){
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
    if(!isNaN(this.estudio.id)){
      //Restauro los valores previos
      this.estudio.titulo=this.copia.titulo;
      this.estudio.institucion=this.copia.institucion;
      this.estudio.urlLogo=this.copia.urlLogo;
      this.estudio.anioInicio=this.copia.anioInicio;
      this.estudio.anioFin=this.copia.anioFin;
    }
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
  
  setActivo(estudio:EstudioData){
    this.estudio=estudio;
    //realizo una copia de seguridad por si no deseo cambiar nada
    this.copia.titulo=estudio.titulo;
    this.copia.institucion=estudio.institucion;
    this.copia.urlLogo=estudio.urlLogo;
    this.copia.anioInicio=estudio.anioInicio;
    this.copia.anioFin=estudio.anioFin;
  }

  eliminarEstudio(){
    this.estudioService.borrarEstudio(this.estudio).subscribe(dato=>{
      let indice=this.estudios.indexOf(this.estudio);
      this.estudios.splice(indice,1);
    });
  }

}
