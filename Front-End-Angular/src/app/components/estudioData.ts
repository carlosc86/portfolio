export interface EstudioData{
    id:number,
    titulo:string,
    institucion:string,
    urlLogo:string,
    anioInicio:string,
    anioFin:string
}


export class Estudio implements EstudioData{
    id: number=NaN;
    titulo: string="";
    institucion: string="";
    urlLogo: string="";
    anioInicio: string="";
    anioFin: string="";
}