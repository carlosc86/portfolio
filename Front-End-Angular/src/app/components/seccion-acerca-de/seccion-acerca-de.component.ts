import { Component, OnInit } from '@angular/core';
import { SeccionDataService } from 'src/app/services/seccion-data.service';
import { EstudioData, estudios } from '../estudioData';
import { HabilidadData, habilidades } from '../habilidadData';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-acerca-de',
  templateUrl: './seccion-acerca-de.component.html',
  styleUrls: ['./seccion-acerca-de.component.css']
})
export class SeccionAcercaDeComponent extends SeccionComponent implements OnInit {

  estudios:EstudioData[]=estudios;
  habilidades:HabilidadData[]=habilidades;

  estudioAEditar:EstudioData={
    id:-1,
    titulo:"",
    institucion:"",
    urlLogo:"",
    anioInicio:"",
    anioFin:""
  };

  habilidadAEditar:HabilidadData={
    id:-1,
    nombre:"",
    descripcion:"",
    porcentaje:50
  };

  constructor(private seccionS:SeccionDataService) {
    super()
   }

  override ngOnInit(): void {
    this.seccionS.traerSeccionPorNombre('Acerca de').subscribe(dato=>{
      this.seccion=dato[0];
    });
  }

  setearEditorEstudio($event:EstudioData){
    this.estudioAEditar=$event;
  }

  setearEditorHabilidad($event:HabilidadData){
    this.habilidadAEditar=$event;
  }

  agregarEstudio($event:EstudioData){
    $event.id=this.estudios.length;
    this.estudios.push($event);
  }

  agregarHabilidad($event:HabilidadData){
    $event.id=this.habilidades.length;
    this.habilidades.push($event);
  }

}
