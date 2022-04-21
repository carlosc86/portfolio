import { Component, OnInit } from '@angular/core';
import { EstudioDataService } from 'src/app/services/estudio-data.service';
import { SeccionDataService } from 'src/app/services/seccion-data.service';
import { EstudioData } from '../estudioData';
import { HabilidadData, habilidades } from '../habilidadData';
import { SeccionComponent } from '../seccion/seccion.component';

@Component({
  selector: 'app-seccion-acerca-de',
  templateUrl: './seccion-acerca-de.component.html',
  styleUrls: ['./seccion-acerca-de.component.css']
})
export class SeccionAcercaDeComponent extends SeccionComponent implements OnInit {

  habilidades:HabilidadData[]=habilidades;

  habilidadAEditar:HabilidadData={
    id:NaN,
    nombre:"",
    descripcion:"",
    porcentaje:50
  };

  constructor(private seccionS:SeccionDataService,
              private estudioService:EstudioDataService) {
    super()
   }

  override ngOnInit(): void {
    this.seccionS.traerSeccionPorNombre('Acerca de').subscribe(dato=>{
      this.seccion=dato[0];
    });
  }

  setearEditorHabilidad($event:HabilidadData){
    this.habilidadAEditar=$event;
  }

  agregarHabilidad($event:HabilidadData){
    $event.id=this.habilidades.length;
    this.habilidades.push($event);
  }

  eliminarHabilidad(){
    console.log("Habilidoso el tuyo");
  }

}
