export class SeccionData{
    
    private _id:number=0;
    private _nombre:string="";
    private _titulo:string="";
    private _texto:string="";
    private  _urlImagen:string="";

    public get id():number{return this._id;}
    public get nombre():string{return this._nombre;}
    public get titulo():string{return this._titulo;}
    public get texto():string{return this._texto;}
    public get urlImagen():string{return this._urlImagen;}

    public set id(id:number){this._id=id;}
    public set nombre(n:string){this._nombre=n;}
    public set titulo(t:string){this._titulo=t;}
    public set texto(t:string){this._texto=t;}
    public set urlImagen(u:string){this._urlImagen=u;}
}