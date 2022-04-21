import { Component, OnInit } from '@angular/core';
import { SeccionDataService } from 'src/app/services/seccion-data.service';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-acerca-de',
  templateUrl: './seccion-acerca-de.component.html',
  styleUrls: ['./seccion-acerca-de.component.css']
})
export class SeccionAcercaDeComponent extends SeccionComponent implements OnInit {

  constructor(private seccionS:SeccionDataService) {
    super()
   }

  override ngOnInit(): void {
    this.seccionS.traerSeccionPorNombre('Acerca de').subscribe(dato=>{
      this.seccion=dato[0];
    });
  }
}
