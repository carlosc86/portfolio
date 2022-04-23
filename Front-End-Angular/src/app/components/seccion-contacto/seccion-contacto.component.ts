import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { MensajeData, mensajes } from '../mensajeData';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-contacto',
  templateUrl: './seccion-contacto.component.html',
  styleUrls: ['./seccion-contacto.component.css']
})
export class SeccionContactoComponent extends SeccionComponent implements OnInit {

  mensajes:MensajeData[]=mensajes;

  constructor() { 
    super();
  }

  override ngOnInit(): void {
    
  }

  guardarMensaje($event:MensajeData){
    $event.id=this.mensajes.length;
    this.mensajes.push($event);
    this.mensajes.sort((e,f)=>moment(f.fecha).unix()-moment(e.fecha).unix());
    alert("Mensaje enviado con exito.");//Enviado con el servicio de mensajes
    console.log(this.mensajes[this.mensajes.length-1]);
  }

}
