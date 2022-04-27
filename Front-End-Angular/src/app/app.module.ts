import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { SeccionInicioComponent } from './components/seccion-inicio/seccion-inicio.component';
import { EditorSeccionComponent } from './components/editor-seccion/editor-seccion.component';
import { SeccionAcercaDeComponent } from './components/seccion-acerca-de/seccion-acerca-de.component';
import { SeccionComponent } from './components/seccion/seccion.component';
import { SeccionTrabajosComponent } from './components/seccion-trabajos/seccion-trabajos.component';
import { SeccionContactoComponent } from './components/seccion-contacto/seccion-contacto.component';
import { EditorEstudioComponent } from './components/editor-estudio/editor-estudio.component';
import { InfoEstudioComponent } from './components/info-estudio/info-estudio.component';
import { InfoHabilidadComponent } from './components/info-habilidad/info-habilidad.component';
import { EditorHabilidadComponent } from './components/editor-habilidad/editor-habilidad.component';
import { InfoExperienciaComponent } from './components/info-experiencia/info-experiencia.component';
import { EditorExperienciaComponent } from './components/editor-experiencia/editor-experiencia.component';
import { InfoProyectoComponent } from './components/info-proyecto/info-proyecto.component';
import { EditorProyectoComponent } from './components/editor-proyecto/editor-proyecto.component';
import { FormEnvioMensajeComponent } from './components/form-envio-mensaje/form-envio-mensaje.component';
import { FormLecturaMensajeComponent } from './components/form-lectura-mensaje/form-lectura-mensaje.component';
import { BarraMenuComponent } from './components/barra-menu/barra-menu.component';
import { InfoMedioContactoComponent } from './components/info-medio-contacto/info-medio-contacto.component';
import { BarraFooterComponent } from './components/barra-footer/barra-footer.component';
import { SeccionDataService } from './services/seccion-data.service';
import { FormBorrarElementoComponent } from './components/form-borrar-elemento/form-borrar-elemento.component';
import { EditorMedioContactoComponent } from './components/editor-medio-contacto/editor-medio-contacto.component';
import { FormLoginComponent } from './components/form-login/form-login.component';
import { InterceptorService } from './services/interceptor.service';
import { ApiComunicationService } from './services/api-comunication.service';
import { DataService } from './services/dataService';
import { AuthenticationService } from './services/authentication.service';
import { EstudioDataService } from './services/estudio-data.service';
import { ExperienciaDataService } from './services/experiencia-data.service';
import { HabilidadDataService } from './services/habilidad-data.service';
import { MedioContactoDataService } from './services/medio-contacto-data.service';
import { PortfolioDTOService } from './services/portfolio-dto.service';
import { ProyectoDataService } from './services/proyecto-data.service';
import { ElementoBotonComponent } from './components/elemento-boton/elemento-boton.component';
import { InfoUsuarioComponent } from './components/info-usuario/info-usuario.component';


@NgModule({
  declarations: [
    AppComponent,
    SeccionInicioComponent,
    EditorSeccionComponent,
    SeccionAcercaDeComponent,
    SeccionComponent,
    SeccionTrabajosComponent,
    SeccionContactoComponent,
    EditorEstudioComponent,
    InfoEstudioComponent,
    InfoHabilidadComponent,
    EditorHabilidadComponent,
    InfoExperienciaComponent,
    EditorExperienciaComponent,
    InfoProyectoComponent,
    EditorProyectoComponent,
    FormEnvioMensajeComponent,
    FormLecturaMensajeComponent,
    BarraMenuComponent,
    InfoMedioContactoComponent,
    BarraFooterComponent,
    FormBorrarElementoComponent,
    EditorMedioContactoComponent,
    FormLoginComponent,
    ElementoBotonComponent,
    InfoUsuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ApiComunicationService,
              AuthenticationService,
              EstudioDataService,
              ExperienciaDataService,
              HabilidadDataService,
              MedioContactoDataService,
              PortfolioDTOService,
              ProyectoDataService,
              SeccionDataService,
              {provide:HTTP_INTERCEPTORS,useClass:InterceptorService, multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
