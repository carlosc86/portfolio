export interface MensajeData{
    id:number,
    nombre:string,
    apellido:string,
    email:string,
    asunto:string,
    mensaje:string,
    fecha:string;
    leido:boolean
};

export const mensajes:MensajeData[]=[
    {
        id:0,
        nombre:"Juan Armando",
        apellido:"Perez",
        email:"jap@mio.com",
        asunto:"Pagina web de asistencia tecnica.",
        mensaje:"Me gustaria saber el precio por hacer una pagina web para brindar asistencia tecnica a los visitantes. Las asistencias seran en temas relacionados con la informatica. ",
        fecha:"2022-04-11",
        leido:false
    },
    {
        id:1,
        nombre:"Pablo",
        apellido:"Gonzalez",
        email:"p.gonzalez@miravista.com",
        asunto:"Single Page Application - Miravista",
        mensaje:"Hola, mi nombre es Pablo. Te consultaba por el proyecto Miravista. Es una app para android, que ofrece a los usuarios la posibilidad de....",
        fecha:"2022-04-08",
        leido:false
    },
    {
        id:2,
        nombre:"Ana",
        apellido:"Lopez",
        email:"ana.lopez@fotoloop.com",
        asunto:"Portfolio para fotografa.",
        mensaje:"Hola, estaba buscando un programador que me realice el portfolio. La idea es mostrar mis mejores y mas premiados trabajos de fotografia.",
        fecha:"2022-04-08",
        leido:false
    },
    {
        id:32,
        nombre:"Maria",
        apellido:"Sanchez",
        email:"maria.s240@artstation.ns",
        asunto:"Portfolio para ilustradora.",
        mensaje:"Quiero que me hagas un portfolio, pero no quiero solo mostrar mis creaciones, ademas quiero que los visitantes me dejen comentarios hacerca de si les gusta o si quieren algo similar.",
        fecha:"2022-04-06",
        leido:true
    },
    {
        id:41,
        nombre:"Pedro",
        apellido:"Gomez",
        email:"pedrito_go_gomez@gmailto.com",
        asunto:"Cotizacion para pagina web.",
        mensaje:"Hola, quisiera saber cuanto me cobras por hacerme una pagina para mi ferreteria, quisiera que la gente me compre los productos online y los retire en la tienda.",
        fecha:"2022-04-05",
        leido:true
    }

    
];