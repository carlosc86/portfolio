export interface ProyectoData{
    id:number,
    nombre:string,
    descripcion:string,
    link:string,
    anio:string,
    urlImagenes:string[] //Pueden ser muchas imagenes del proyecto
}

export const proyectos:ProyectoData[]=[
    {
        id:0,
        nombre:"Mooncakes of the moon",
        descripcion:"Descripcion del proyecto a fondo, para llamar la atencion, chookitty. ",
        link:"www.google.com",
        anio:"2015",
        urlImagenes:["../../../assets/mooncake.png",
                    "../../../assets/error404.png"]
    },
    {
        id:1,
        nombre:"Pagina Web de consultorias",
        descripcion:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vulputate metus justo. Sed porttitor tempus dolor, nec pretium magna dapibus quis.",
        link:"www.google.com",
        anio:"2017",
        urlImagenes:["../../../assets/consulting.png",
                    "../../../assets/error404.png"]
    },
    {
        id:2,
        nombre:"Aplicacion web NetCat",
        descripcion:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vulputate metus justo. Sed porttitor tempus dolor.",
        link:"www.google.com",
        anio:"2019",
        urlImagenes:["../../../assets/redcat.png",
                    "../../../assets/error404.png"]
    }
];