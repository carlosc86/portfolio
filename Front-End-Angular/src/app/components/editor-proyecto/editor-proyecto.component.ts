import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
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
    
  constructor(private fb:FormBuilder, private proyectoService:ProyectoDataService) {
    super(proyectoService);
    this.forms=fb.group({
      nombre:[''],
      descripcion:[''],
      link:[''],
      anio:[''],
      urlImagen:[''] //CUIDADO ACA SE DEBE INGRESAR UN ARRAY
    });
   }
  override setActivo(dato: ProyectoData): void {
    super.setActivo(dato);
    this.listaRutas=dato.urlImagenes;
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
        anio:"",
        urlImagenes:[""]
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
    this.elemento.urlImagenes=this.listaRutas;
    this.aceptar();
  }
}
