import { Component, Input, OnInit } from '@angular/core';
import * as moment from 'moment';
import { MensajeData, mensajes } from '../mensajeData';

@Component({
  selector: 'app-form-lectura-mensaje',
  templateUrl: './form-lectura-mensaje.component.html',
  styleUrls: ['./form-lectura-mensaje.component.css']
})
export class FormLecturaMensajeComponent implements OnInit {

  @Input() mensajes:MensajeData[]=[];
  mensajeActivo:MensajeData={
    id:-1,
    nombre:"",
    apellido:"",
    email:"",
    asunto:"",
    mensaje:"",
    fecha:"",
    leido:false
  };

  constructor() { }

  ngOnInit(): void {
    moment.locale('es');
  }

  darFormatoFecha(fecha:string,completa:boolean){
    if(fecha.length>0){
      if(completa)
        return moment(fecha,"YYYY-MM-DD").format("DD-MM-YYYY");
      else 
        return moment(fecha,"YYYY-MM-DD").format("DD-MM-YY");
    }else return "";
  }

  leerMensaje(id:number){
    this.mensajeActivo=mensajes.find(e => e.id==id)!;
    if(this.mensajeActivo!=null){
      this.mensajeActivo.leido=true;
    }    
  }

  siguienteMensaje(){
    let indice=this.mensajes.indexOf(this.mensajeActivo);
    if(indice+1<this.mensajes.length){
      this.mensajeActivo=this.mensajes[indice+1];
      if(!this.mensajeActivo.leido){
        this.mensajeActivo.leido=true;
      }
    }
  }

  anteriorMensaje(){
    let indice=this.mensajes.indexOf(this.mensajeActivo);
    if(indice-1>=0){
      this.mensajeActivo=this.mensajes[indice-1];
      if(!this.mensajeActivo.leido){
        this.mensajeActivo.leido=true;
      }
    }

  }

}
