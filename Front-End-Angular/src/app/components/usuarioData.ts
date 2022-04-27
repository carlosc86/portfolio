export interface UsuarioData{
    id:number,
    nombre:string,
    apellido:string,
    email:string,
    privilegios:"invitado"|"administrador",
    urlIcono:string
}