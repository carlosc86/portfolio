import { Component, OnInit } from '@angular/core';
import { SeccionData } from '../seccionData';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SeccionDataService } from 'src/app/services/seccion-data.service';
import { EditorData } from '../editorData';
import { PortfolioDTOService } from 'src/app/services/portfolio-dto.service';

@Component({
  selector: 'app-editor-seccion',
  templateUrl: './editor-seccion.component.html',
  styleUrls: ['./editor-seccion.component.css']
})
export class EditorSeccionComponent extends EditorData<SeccionData> implements OnInit {
  

  constructor( private fb:FormBuilder,private seccionS:SeccionDataService,private pdto:PortfolioDTOService) { 
    super(seccionS);
    this.forms=fb.group({
      titulo:['',],
      rutaImagen:['',],
      texto:['',]
    });
  }
  override ngOnInit(): void {
    this.pdto.obtener<SeccionData>('secciones').subscribe(dato=>{
      this.lista=dato
    });
  }

  protected borrarElemento(): SeccionData {
    return {id:NaN,
      nombre:"",
      titulo:"",
      texto:"",
      rutaImagen:""};
  }

  getSeccionPorNombre(nombre:string):SeccionData{
    let seccionEncontrada=this.lista.find(e=>e.nombre===nombre);
    return seccionEncontrada? seccionEncontrada : this.borrarElemento();
  }
}
