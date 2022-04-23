import { Component,  OnInit,  } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HabilidadDataService } from 'src/app/services/habilidad-data.service';
import { EditorData } from '../editorData';
import { EstudioData } from '../estudioData';
import { HabilidadData } from '../habilidadData';

@Component({
  selector: 'app-editor-habilidad',
  templateUrl: './editor-habilidad.component.html',
  styleUrls: ['./editor-habilidad.component.css']
})
export class EditorHabilidadComponent extends EditorData<HabilidadData> implements OnInit {
  
  constructor(private fb:FormBuilder,
              private habilidadService:HabilidadDataService) {
    super(habilidadService);
    this.forms=fb.group({
      nombre:[''],
      descripcion:[''],
      porcentaje:[50]
    });
   }

   protected borrarElemento(): HabilidadData {
    return {
      id:NaN,
      nombre:"",
      descripcion:"",
      porcentaje:50
    };
  }

}
