import { Component, OnInit } from '@angular/core';
import { SeccionDataService } from 'src/app/services/seccion-data.service';
import { ExperienciaData, experiencias } from '../experienciaData';
import { ProyectoData, proyectos } from '../proyectoData';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-trabajos',
  templateUrl: './seccion-trabajos.component.html',
  styleUrls: ['./seccion-trabajos.component.css']
})
export class SeccionTrabajosComponent extends SeccionComponent implements OnInit {

  experiencias:ExperienciaData[]=experiencias;
  proyectos:ProyectoData[]=proyectos;
  
  experAEditar:ExperienciaData={
    id:-1,
    puesto:"",
    tipoTrabajo:"",
    descripcion:"",
    nombreEmpresa:"",
    urlLogoEmpresa:"",
    fechaInicio:"",
    fechaFin:""
  };

  proyectoAEditar:ProyectoData={
    id:-1,
    nombre:"",
    descripcion:"",
    link:"",
    anio:"",
    urlImagenes:[""]
  }

  constructor(private seccionS:SeccionDataService) {
    super();
   }

  override ngOnInit(): void {
    this.seccionS.traerSeccionPorNombre("Trabajos").subscribe(dato=>{
      this.seccion=dato[0];
    });
  }

  setearExperiencia(event:ExperienciaData){
    this.experAEditar=event;
  }

  setearProyecto($event:ProyectoData){
    this.proyectoAEditar=$event;
  }

  agregarExperiencia($event:ExperienciaData){
    $event.id=this.experiencias.length;
    this.experiencias.push($event);
  }

  agregarProyecto($event:ProyectoData){
    $event.id=this.proyectos.length;
    this.proyectos.push($event);
  }
  

}
