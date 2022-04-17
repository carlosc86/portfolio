export interface EstudioData{
    id:number,
    titulo:string,
    institucion:string,
    urlLogo:string,
    anioInicio:string,
    anioFin:string
}

export const estudios:EstudioData[]=[
    {id:0,titulo:"Tecnico Electronico - Automatizacion",institucion:"Escuela Presbitero Constantino Spagnolo",urlLogo:"../../../assets/electronics.png",anioInicio:"2002",anioFin:"2006"},
    {id:1,titulo:"Estudiante Ingenieria en Sistemas",institucion:"UTN - Facultad Regional Mendoza",urlLogo:"../../../assets/computer.png",anioInicio:"2006",anioFin:"2010"},
    {id:2,titulo:"Programado Full Stack Web",institucion:"Ministerio de Desarrollo Productivo",urlLogo:"../../../assets/network.png",anioInicio:"2021",anioFin:"2022"}];