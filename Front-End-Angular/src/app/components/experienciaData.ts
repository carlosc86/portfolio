export interface ExperienciaData{
    id:number,
    puesto:string,
    tipoTrabajo:string,
    descripcion:string,
    nombreEmpresa:string,
    urlLogoEmpresa:string,
    fechaInicio:string,
    fechaFin:string
}

export const experiencias:ExperienciaData[]=[
    {id:0,
        puesto:"Programador",
        tipoTrabajo:"part-time",
        descripcion:"Programe y mantuve el codigo para su pagina web, asesoraba sobre la compra de equipos.",
        nombreEmpresa:"Googles",
        urlLogoEmpresa:"../../../assets/Logo_Exp.png",
        fechaInicio:"2012",
        fechaFin:"2015"
    },
    {id:1,
        puesto:"Tecnico en Redes",
        tipoTrabajo:"full-time",
        descripcion:"Tendia y mantenia las redes LAN cableadas dentro de la empresa. Mantenia los equipos wireless para las unidades moviles de la empresa.",
        nombreEmpresa:"Tecnicorp",
        urlLogoEmpresa:"../../../assets/Logo_Exp.png",
        fechaInicio:"2016",
        fechaFin:"2018"
       },
    {id:2,
        puesto:"Encuestador",
        tipoTrabajo:"freelance",
        descripcion:"Realizaba encuestas de mercadeo para una empresa de comunicaciones.",
        nombreEmpresa:"Asterix",
        urlLogoEmpresa:"../../../assets/Logo_Exp.png",
        fechaInicio:"2019",
        fechaFin:"2020"
       }
];