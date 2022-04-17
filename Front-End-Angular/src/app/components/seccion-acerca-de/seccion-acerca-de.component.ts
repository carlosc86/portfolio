import { Component, OnInit } from '@angular/core';
import { EstudioData, estudios } from '../estudioData';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-acerca-de',
  templateUrl: './seccion-acerca-de.component.html',
  styleUrls: ['./seccion-acerca-de.component.css']
})
export class SeccionAcercaDeComponent extends SeccionComponent implements OnInit {

  estudios:EstudioData[]=estudios;
  estudioAEditar:EstudioData={
    id:-1,
    titulo:"",
    institucion:"",
    urlLogo:"",
    anioInicio:"",
    anioFin:""
  };

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

  setearEditor($event:EstudioData){
    this.estudioAEditar=$event;
  }

  agregarEstudio($event:EstudioData){
    $event.id=this.estudios.length;
    this.estudios.push($event);
  }

}
