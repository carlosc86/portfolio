import { Component, OnInit } from '@angular/core';
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
    this.seccion.titulo="TRABAJOS";
    this.seccion.texto="Algunos trabajos y proyectos para mostrar mis habilidades.";
    this.seccion.nombre="Trabajos";
    this.seccion.id=3;
  }

}
