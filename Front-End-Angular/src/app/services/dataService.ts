import { Observable } from "rxjs";
import { ApiComunicationService } from "./api-comunication.service";
import { DataPortfolio } from "./data";

export class DataService {

    protected endpointRoot:string="";

    constructor(protected api:ApiComunicationService){
        
    }

    traer<T extends DataPortfolio>():Observable<T[]>{
        return this.api.getUrl(this.endpointRoot);
    };
    agregar<T extends DataPortfolio>(dato:T):Observable<T>{
        return this.api.postUrl(this.endpointRoot,dato);
    };
    modificar<T extends DataPortfolio>(dato:T):Observable<T>{
        return this.api.putUrl(this.endpointRoot+"/"+dato.id,dato);
    };
    borrar<T extends DataPortfolio>(dato:T):Observable<T>{
        return this.api.deleteUrl(this.endpointRoot+"/"+dato.id);
    };
}