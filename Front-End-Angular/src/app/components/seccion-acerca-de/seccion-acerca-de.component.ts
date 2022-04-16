import { Component, OnInit } from '@angular/core';
import { SeccionComponent } from '../seccion/seccion.component';
import { SeccionData } from '../seccionData';

@Component({
  selector: 'app-seccion-acerca-de',
  templateUrl: './seccion-acerca-de.component.html',
  styleUrls: ['./seccion-acerca-de.component.css']
})
export class SeccionAcercaDeComponent extends SeccionComponent implements OnInit {


  constructor() {
    super()
   }

  override ngOnInit(): void {
    this.seccion.titulo="ACERCA DE";
    this.seccion.urlImagen="../../../assets/portrait.png";
    this.seccion.texto="Soy un programador full stack web independiente. Me gusta programar para diferentes dispositivos, en diferentes lenguajes y plataformas.";
    this.seccion.nombre="Acerca de";
    this.seccion.id=2;
  }

}
