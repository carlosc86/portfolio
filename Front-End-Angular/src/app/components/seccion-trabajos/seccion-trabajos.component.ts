import { Component, OnInit } from '@angular/core';
import { ProyectoData, proyectos } from '../proyectoData';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-trabajos',
  templateUrl: './seccion-trabajos.component.html',
  styleUrls: ['./seccion-trabajos.component.css']
})
export class SeccionTrabajosComponent extends SeccionComponent implements OnInit {

  constructor() {
    super();
   }

  override ngOnInit(): void {
    
  } 

}
