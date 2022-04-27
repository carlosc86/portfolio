import { Observable } from "rxjs";
import { ApiComunicationService } from "./api-comunication.service";
import { DataPortfolio } from "./data";


/* Clase generica para hacer servicios */

export class DataService<T extends DataPortfolio> {

    protected endpointRoot:string="";

    constructor(protected api:ApiComunicationService){
        
    }

    traer():Observable<T[]>{
        return this.api.getUrl(this.endpointRoot);
    };
    agregar(dato:T):Observable<T>{
        return this.api.postUrl(this.endpointRoot,dato);
    };
    modificar(dato:T):Observable<T>{
        return this.api.putUrl(this.endpointRoot+"/"+dato.id,dato);
    };
    borrar(dato:T):Observable<T>{
        return this.api.deleteUrl(this.endpointRoot+"/"+dato.id);
    };

}