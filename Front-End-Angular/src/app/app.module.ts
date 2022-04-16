import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SeccionInicioComponent } from './components/seccion-inicio/seccion-inicio.component';
import { EditarSeccionComponent } from './components/editar-seccion/editar-seccion.component';
import { SeccionAcercaDeComponent } from './components/seccion-acerca-de/seccion-acerca-de.component';
import { SeccionComponent } from './components/seccion/seccion.component';
import { SeccionTrabajosComponent } from './components/seccion-trabajos/seccion-trabajos.component';
import { SeccionContactoComponent } from './components/seccion-contacto/seccion-contacto.component';

@NgModule({
  declarations: [
    AppComponent,
    SeccionInicioComponent,
    EditarSeccionComponent,
    SeccionAcercaDeComponent,
    SeccionComponent,
    SeccionTrabajosComponent,
    SeccionContactoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
