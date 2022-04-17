export interface HabilidadData{
    id:number,
    nombre:string,
    descripcion:string,
    porcentaje:number
}

export const habilidades:HabilidadData[]=[
    {id:0,nombre:"HTML",descripcion:"Lenguaje de etiquetas para la creacion de paginas web.", porcentaje:85},
    {id:1,nombre:"CSSS",descripcion:"Lenguaje de hojas de estilo en cascada.", porcentaje:80},
    {id:2,nombre:"JavaScript",descripcion:"Lenguaje que aporta funcionalidad a las paginas web.", porcentaje:75},
    {id:3,nombre:"Bootstrap",descripcion:"Framework para la creacion rapida de sitios responsive", porcentaje:70},
    {id:4,nombre:"Angular",descripcion:"Framework para la creacion de Front-End y aplicaciones SPA", porcentaje:70},
    {id:5,nombre:"BaseDatos(SQL)",descripcion:"Manejo de base de datos y utilizacion del lenguaje SQL", porcentaje:75},
    {id:6,nombre:"Spring(JAVA)",descripcion:"Framework para la creacion de servidores API REST (Back-End)", porcentaje:70},
    {id:7,nombre:"C/C++",descripcion:"Lenguaje de programacion de bajo nivel, para crear aplicaciones mas eficientes", porcentaje:80}
];