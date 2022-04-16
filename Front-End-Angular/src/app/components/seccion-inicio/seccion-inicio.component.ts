import { Component, OnInit } from '@angular/core';
import { Seccion } from '../seccion';

@Component({
  selector: 'app-seccion-inicio',
  templateUrl: './seccion-inicio.component.html',
  styleUrls: ['./seccion-inicio.component.css']
})
export class SeccionInicioComponent implements OnInit {

  public seccion:Seccion=new Seccion();

  constructor() { }

  ngOnInit(): void {
    this.seccion.setTitulo("CARLOS ALEXANDER CARRICONDO");
    this.seccion.setTexto("Programador Full Stack Web");
    this.seccion.setUrlImagen("../../../assets/portrait.png");
  }
  

}
