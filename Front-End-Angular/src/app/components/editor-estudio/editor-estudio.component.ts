import { Component, OnInit} from '@angular/core';
import { FormBuilder} from '@angular/forms';
import { EstudioDataService } from 'src/app/services/estudio-data.service';
import { PortfolioDTOService } from 'src/app/services/portfolio-dto.service';
import { EditorData } from '../editorData';
import { EstudioData } from '../estudioData';

@Component({
  selector: 'app-editor-estudio',
  templateUrl: './editor-estudio.component.html',
  styleUrls: ['./editor-estudio.component.css']
})
export class EditorEstudioComponent extends EditorData<EstudioData> implements OnInit{

  constructor(private fb:FormBuilder, private estudioService:EstudioDataService, private pdto:PortfolioDTOService) {
    super(estudioService);           
    this.forms=fb.group({
      titulo:[''],
      institucion:[''],
      urlLogo:[''],
      anioInicio:[''],
      anioFin:['']
    });
   }
  override ngOnInit(): void {
    this.pdto.obtener<EstudioData>("estudios").subscribe(dato=>{
      this.lista=dato
    });
  }

  protected borrarElemento(){
    return {
      id:NaN,
      titulo:"",
      institucion:"",
      urlLogo:"",
      anioInicio:"",
      anioFin:""
    };
  }

}
