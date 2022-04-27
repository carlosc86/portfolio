import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { MedioContactoDataService } from 'src/app/services/medio-contacto-data.service';
import { PortfolioDTOService } from 'src/app/services/portfolio-dto.service';
import { MedioContactoData } from '../medioContactoData';

@Component({
  selector: 'app-barra-menu',
  templateUrl: './barra-menu.component.html',
  styleUrls: ['./barra-menu.component.css']
})
export class BarraMenuComponent implements OnInit {
  mediosContacto:MedioContactoData[]=[];
  usuario:string="Carlos";

  constructor(private mediosContactoService:MedioContactoDataService, 
              private pdto:PortfolioDTOService,
              private authService:AuthenticationService) { }

  ngOnInit(): void {
    this.pdto.obtener<MedioContactoData>("medios_contacto").subscribe(dato=>{
      this.mediosContacto=dato
    });
  }

  isLogin(){
    return this.authService.isLogin();
  }

  logout(evento:Event){
    //this.usuario="";
    evento.preventDefault();
    this.authService.logout().subscribe(data=>{
      console.log(`Se deslogueo exitosamente ${data}`);
    });
  }

  cargarLista(medios:MedioContactoData[]){
    this.mediosContacto=medios;
  }

}
