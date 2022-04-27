import { Component, OnInit } from '@angular/core';
import { SeccionComponent } from '../seccion/seccion.component';


@Component({
  selector: 'app-seccion-inicio',
  templateUrl: './seccion-inicio.component.html',
  styleUrls: ['./seccion-inicio.component.css']
})
export class SeccionInicioComponent extends SeccionComponent implements OnInit {


  constructor() { 
    super();
  }

  override ngOnInit(): void {
    
  } 

}
