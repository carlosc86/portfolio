import { Component, OnInit } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { DataPortfolio } from "../services/data";
import { DataService } from "../services/dataService";
import { PortfolioDTOService } from "../services/portfolio-dto.service";

/* Clase generica para el manejo de edicion de elementos */

@Component({
    selector: 'app-editor-data-component',
    template: '<h1>Editor</h1>',
    styleUrls:[]
})
export abstract class EditorData<T extends DataPortfolio> implements OnInit{

    public lista:T[]=[];
    public elemento:T;
    public copia:T;
    public forms!:FormGroup;

    constructor(protected dataService:DataService<T>,
                /*protected onLoadService:PortfolioDTOService*/){
        this.elemento=this.borrarElemento();
        this.copia=this.borrarElemento();

    } 

    ngOnInit(){
        /* //Habilitar cuando este la api resuelta
       this.onLoadService.traer().subscribe(dato=>{
            this.lista=obtenerDatos(dato);
       });
       */
        this.dataService.traer().subscribe(dato=>{
            this.lista=dato;
        });
    }

    cancelar(){
        let indice=this.lista.indexOf(this.elemento);
        this.elemento=this.copiarElemento(this.copia);
        this.lista[indice]=this.elemento;
        this.resetForm();
    }
    aceptar(){
        if(isNaN(this.elemento.id)){
            this.dataService.agregar(this.elemento).subscribe(dato=>{
                this.elemento.id=dato.id;
                this.lista.push(this.elemento);
                this.resetForm();
            });
        }else
            this.dataService.modificar(this.elemento).subscribe(dato=>{
                this.resetForm();
            });
    }

    eliminar(){
        if(!isNaN(this.elemento.id)){
            this.dataService.borrar(this.elemento).subscribe(dato=>{
                let indice=this.lista.indexOf(this.elemento);
                this.lista.splice(indice,1);
                this.resetForm();
            });
        }
    }
    
    setActivo(dato:T){
        this.elemento=dato;
        this.copia=this.copiarElemento(dato);
    }
    
    resetForm(){
        this.elemento=this.borrarElemento();
        this.forms!.reset();   
    }

    protected  copiarElemento(dato:T):T{
        return JSON.parse(JSON.stringify(dato));
    }

    protected abstract borrarElemento():T; //Devuelve un elemento limpio
    


}