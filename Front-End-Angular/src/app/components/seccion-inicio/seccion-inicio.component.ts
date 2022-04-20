import { Component, OnInit } from '@angular/core';
import { SeccionDataService } from 'src/app/services/seccion-data.service';
import { SeccionComponent } from '../seccion/seccion.component';
import { SeccionData } from '../seccionData';

@Component({
  selector: 'app-seccion-inicio',
  templateUrl: './seccion-inicio.component.html',
  styleUrls: ['./seccion-inicio.component.css']
})
export class SeccionInicioComponent extends SeccionComponent implements OnInit {


  constructor(private seccionS:SeccionDataService) { 
    super();
  }

  override ngOnInit(): void {
    this.seccionS.traerSeccionPorNombre('Inicio').subscribe(dato=>{
      this.seccion=dato[0];
    });
  } 

}
