import { Observable } from "rxjs";
import { ApiComunicationService } from "./api-comunication.service";
import { DataPortfolio } from "./data";


/* Clase generica para hacer servicios */

export class DataService<T extends DataPortfolio> {

    protected endpointRoot:string="";

    constructor(protected api:ApiComunicationService){
        
    }

    traer(ruta?:string):Observable<T[]>{
        return this.api.getUrl(ruta?ruta:this.endpointRoot);
    };
    agregar(dato:T,ruta?:string):Observable<T>{
        return this.api.postUrl(ruta?ruta:this.endpointRoot,dato);
    };
    modificar(dato:T,ruta?:string):Observable<T>{
        return this.api.putUrl((ruta?ruta:this.endpointRoot)+"/"+dato.id,dato);
    };
    borrar(dato:T,ruta?:string):Observable<T>{
        return this.api.deleteUrl((ruta?ruta:this.endpointRoot)+"/"+dato.id);
    };

}