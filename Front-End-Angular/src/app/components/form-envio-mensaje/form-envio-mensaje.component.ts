import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { AbstractControl, EmailValidator, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MensajeData } from '../mensajeData';

@Component({
  selector: 'app-form-envio-mensaje',
  templateUrl: './form-envio-mensaje.component.html',
  styleUrls: ['./form-envio-mensaje.component.css']
})
export class FormEnvioMensajeComponent implements OnInit {

  @Output() cartero:EventEmitter<MensajeData>=new EventEmitter<MensajeData>();
  correo:MensajeData={
    id:-1,
    nombre:"",
    apellido:"",
    email:"",
    asunto:"",
    mensaje:"",
    leido:false
  };

  formulario:FormGroup;

  constructor(private fb:FormBuilder) { 
    let soloLetras="[A-Za-z ]*"; //Expresion regular para solo letras
    this.formulario=fb.group({
      nombre:['', [Validators.required,Validators.minLength(2),Validators.pattern(soloLetras)]],
      apellido:['', [Validators.required,Validators.minLength(2),Validators.pattern(soloLetras)]],
      email:['', [Validators.required, Validators.email]],
      asunto:['',  [Validators.required,Validators.minLength(5)]],
      mensaje:['',[Validators.required,Validators.minLength(15)]]
    });
  }

  ngOnInit(): void {

  }

  get nombre(){ return this.formulario.get('nombre')!;}
  get apellido(){ return this.formulario.get('apellido')!;}
  get email(){ return this.formulario.get('email')!;}
  get asunto(){ return this.formulario.get('asunto')!;}
  get mensaje(){ return this.formulario.get('mensaje')!;}

  aceptar(){
    this.formulario.markAllAsTouched();
    if(this.formulario.valid){
      this.correo.nombre=this.formulario.value.nombre;
      this.correo.apellido=this.formulario.value.apellido;
      this.correo.email=this.formulario.value.email;
      this.correo.asunto=this.formulario.value.asunto;
      this.correo.mensaje=this.formulario.value.mensaje;
      this.cartero.emit(this.correo);
      this.formulario.reset();
    }
    
  }

}
