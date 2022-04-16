import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SeccionInicioComponent } from './components/seccion-inicio/seccion-inicio.component';
import { EditarSeccionComponent } from './components/editar-seccion/editar-seccion.component';

@NgModule({
  declarations: [
    AppComponent,
    SeccionInicioComponent,
    EditarSeccionComponent
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
