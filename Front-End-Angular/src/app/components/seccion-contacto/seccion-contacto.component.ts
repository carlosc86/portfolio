import { Component, OnInit } from '@angular/core';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-contacto',
  templateUrl: './seccion-contacto.component.html',
  styleUrls: ['./seccion-contacto.component.css']
})
export class SeccionContactoComponent extends SeccionComponent implements OnInit {


  constructor() { 
    super();
  }

  override ngOnInit(): void {
    
  }

}
