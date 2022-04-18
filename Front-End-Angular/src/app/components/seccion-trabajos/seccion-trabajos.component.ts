import { Component, OnInit } from '@angular/core';
import { ExperienciaData, experiencias } from '../experienciaData';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-trabajos',
  templateUrl: './seccion-trabajos.component.html',
  styleUrls: ['./seccion-trabajos.component.css']
})
export class SeccionTrabajosComponent extends SeccionComponent implements OnInit {

  experiencias:ExperienciaData[]=experiencias;
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

  constructor() {
    super();
   }

  override ngOnInit(): void {
    this.seccion.titulo="TRABAJOS";
    this.seccion.texto="Algunos trabajos y proyectos para mostrar mis habilidades.";
    this.seccion.nombre="Trabajos";
    this.seccion.id=3;
  }

  setearExperiencia($event:ExperienciaData){
    this.experAEditar=$event;
  }

  agregarExperiencia($event:ExperienciaData){
    $event.id=this.experiencias.length;
    this.experiencias.push($event);
  }
  

}
