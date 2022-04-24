import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MedioContactoDataService } from 'src/app/services/medio-contacto-data.service';
import { EditorData } from '../editorData';
import { MedioContactoData } from '../medioContactoData';

@Component({
  selector: 'app-editor-medio-contacto',
  templateUrl: './editor-medio-contacto.component.html',
  styleUrls: ['./editor-medio-contacto.component.css']
})
export class EditorMedioContactoComponent extends EditorData<MedioContactoData> implements OnInit {
  
  @Input() public override lista: MedioContactoData[]=[];
  @Output() actualizar:EventEmitter<MedioContactoData[]>=new EventEmitter<MedioContactoData[]>();

  constructor(private fb:FormBuilder, protected medioContactoService:MedioContactoDataService) { 
    super(medioContactoService);
    this.forms=fb.group({
      url:[''],
      empresa:[''],
      urlLogo:['']
    });
  }

  protected borrarElemento(): MedioContactoData {
    return {
      id:NaN,
      url:"",
      empresa:"",
      urlLogo:""
    };
  }

  agregarMedio(){
    this.aceptar()
    this.actualizar.emit(this.lista);
  }

  borrarMedio(){
    this.eliminar();
    this.actualizar.emit(this.lista);
  }
}
