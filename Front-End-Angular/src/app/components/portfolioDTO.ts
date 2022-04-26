import { EstudioData } from "./estudioData";
import { ExperienciaData } from "./experienciaData";
import { HabilidadData } from "./habilidadData";
import { MedioContactoData } from "./medioContactoData";
import { ProyectoData } from "./proyectoData";
import { SeccionData } from "./seccionData";

export interface PortfolioDTO{
    id:number,
    secciones:SeccionData[],
    estudios:EstudioData[],
    habilidades:HabilidadData[],
    experiencias:ExperienciaData[],
    proyectos:ProyectoData[],
    medios_contacto:MedioContactoData[]
}