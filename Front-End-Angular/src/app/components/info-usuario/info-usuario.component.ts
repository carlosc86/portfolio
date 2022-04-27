import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UsuarioData } from '../usuarioData';

@Component({
  selector: 'app-info-usuario',
  templateUrl: './info-usuario.component.html',
  styleUrls: ['./info-usuario.component.css']
})
export class InfoUsuarioComponent implements OnInit {

  usuario:UsuarioData={//Defino un usuario vacio.
    id:NaN,
    nombre:"",
    apellido:"",
    email:"",
    privilegios:"invitado",
    urlIcono:""
  }

  constructor(private authService:AuthenticationService) { }

  ngOnInit(): void {
      this.authService.usuario.subscribe(data=>{
        this.usuario=data;
      });
  }

  visible():boolean{
    return this.authService.isLogin();
  }

}
