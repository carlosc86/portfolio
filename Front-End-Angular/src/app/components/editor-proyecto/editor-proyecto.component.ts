import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PortfolioDTOService } from 'src/app/services/portfolio-dto.service';
import { ProyectoDataService } from 'src/app/services/proyecto-data.service';
import { EditorData } from '../editorData';
import { ProyectoData } from '../proyectoData';

@Component({
  selector: 'app-editor-proyecto',
  templateUrl: './editor-proyecto.component.html',
  styleUrls: ['./editor-proyecto.component.css']
})
export class EditorProyectoComponent extends EditorData<ProyectoData> implements OnInit {
 
  listaRutas:string[]=[];
    
  constructor(private fb:FormBuilder, private proyectoService:ProyectoDataService, private pdto:PortfolioDTOService) {
    super(proyectoService);
    this.forms=fb.group({
      nombre:[''],
      descripcion:[''],
      link:[''],
      anio:[''],
      urlImagen:[''] //CUIDADO ACA SE DEBE INGRESAR UN ARRAY
    });
   }

   override ngOnInit(): void {
    this.pdto.obtener<ProyectoData>("proyectos").subscribe(dato=>{
      this.lista=dato
    });
  }
  override setActivo(dato: ProyectoData): void {
    super.setActivo(dato);
    this.listaRutas=dato.rutasImagenes;
  }

  override resetForm(): void {
    super.resetForm();
    this.listaRutas=[];
  }

  protected borrarElemento(): ProyectoData {
    return {
        id:NaN,
        nombre:"",
        descripcion:"",
        link:"",
        fecha:"",
        rutasImagenes:[""]
      }
  }

  agregarALista(){
    this.listaRutas.push(this.forms.value.urlImagen);
    this.forms.get('urlImagen')?.reset();
  }

  quitarDeLista(ruta:string){
    let indice=this.listaRutas.indexOf(ruta);
    this.listaRutas.splice(indice,1);
  }

  confirmarCambios(){
    this.elemento.rutasImagenes=this.listaRutas;
    this.aceptar();
  }
}
