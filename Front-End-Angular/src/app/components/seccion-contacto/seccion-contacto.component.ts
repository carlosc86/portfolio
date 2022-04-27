import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-contacto',
  templateUrl: './seccion-contacto.component.html',
  styleUrls: ['./seccion-contacto.component.css']
})
export class SeccionContactoComponent extends SeccionComponent implements OnInit {


  constructor(private authService:AuthenticationService) { 
    super();
  }

  override ngOnInit(): void {
    
  }

  isUser():boolean{
    return this.authService.isLogin();
  }

}
