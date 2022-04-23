import { Component, OnInit } from '@angular/core';
import { ProyectoData, proyectos } from '../proyectoData';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-trabajos',
  templateUrl: './seccion-trabajos.component.html',
  styleUrls: ['./seccion-trabajos.component.css']
})
export class SeccionTrabajosComponent extends SeccionComponent implements OnInit {

  
  proyectos:ProyectoData[]=proyectos;

  proyectoAEditar:ProyectoData={
    id:-1,
    nombre:"",
    descripcion:"",
    link:"",
    anio:"",
    urlImagenes:[""]
  }

  constructor() {
    super();
   }

  override ngOnInit(): void {
    
  }

  setearProyecto($event:ProyectoData){
    this.proyectoAEditar=$event;
  }

  agregarProyecto($event:ProyectoData){
    $event.id=this.proyectos.length;
    this.proyectos.push($event);
  }
  

}
