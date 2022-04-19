import { Component, OnInit } from '@angular/core';
import { MensajeData } from '../mensajeData';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-contacto',
  templateUrl: './seccion-contacto.component.html',
  styleUrls: ['./seccion-contacto.component.css']
})
export class SeccionContactoComponent extends SeccionComponent implements OnInit {

  mensajes:MensajeData[]=[];

  constructor() { 
    super();
  }

  override ngOnInit(): void {
    this.seccion.titulo="CONTACTO";
    this.seccion.texto="Si necesita de mis servicios, hagamelo saber. Deje un mensaje";
    this.seccion.nombre="Contacto";
    this.seccion.id=4;
  }

  guardarMensaje($event:MensajeData){
    $event.id=this.mensajes.length;
    this.mensajes.push($event);
    alert("Mensaje enviado con exito.");//Enviado con el servicio de mensajes
    console.log(this.mensajes[this.mensajes.length-1]);
  }

}
