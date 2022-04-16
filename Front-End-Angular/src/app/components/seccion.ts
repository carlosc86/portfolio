export class Seccion{
    private titulo:string="";
    private texto:string="";
    private  urlImagen:string="";

    getTitulo():string{return this.titulo;}
    getTexto():string{return this.texto;}
    getUrlImagen():string{return this.urlImagen;}
    setTitulo(t:string){this.titulo=t;}
    setTexto(t:string){this.texto=t;}
    setUrlImagen(u:string){this.urlImagen=u;}
}