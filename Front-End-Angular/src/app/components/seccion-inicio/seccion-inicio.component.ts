import { Component, OnInit } from '@angular/core';
import { SeccionComponent } from '../seccion/seccion.component';
import { SeccionData } from '../seccionData';

@Component({
  selector: 'app-seccion-inicio',
  templateUrl: './seccion-inicio.component.html',
  styleUrls: ['./seccion-inicio.component.css']
})
export class SeccionInicioComponent extends SeccionComponent implements OnInit {


  constructor() { 
    super();
  }

  override ngOnInit(): void {
    this.seccion.titulo="CARLOS ALEXANDER CARRICONDO";
    this.seccion.texto="Programador Full Stack Web";
    this.seccion.urlImagen="../../../assets/portrait.png";
    this.seccion.nombre="Inicio";
    this.seccion.id=1;
  } 

}
