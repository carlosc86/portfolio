import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CredencialData } from '../credencialData';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css']
})
export class FormLoginComponent implements OnInit {
  credenciales:CredencialData={
    user:"",
    password:""
  }

  form:FormGroup;

  constructor(private fb:FormBuilder, private authService:AuthenticationService) { 
    this.form=fb.group({
      usuario:['',[Validators.required]],
      password:['',[Validators.required,Validators.minLength(8)]]
    });
  }

  ngOnInit(): void {
  }
  //Metodos para simplificar el uso del form en el template
  get usuario(){return this.form.get("usuario")!}
  get password(){return this.form.get("password")!}
  
  //Metodo para llamar al servicio de login
  login(event:Event){
    event.preventDefault();
    this.form.markAllAsTouched();
    if(this.form.valid){
      this.authService.login(this.credenciales).subscribe(data=>{
        console.log("Se inicio sesion exitosamente ");
      });
    }
  }

}
