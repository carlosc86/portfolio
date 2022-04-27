import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-barra-footer',
  templateUrl: './barra-footer.component.html',
  styleUrls: ['./barra-footer.component.css']
})
export class BarraFooterComponent implements OnInit {
  anio:string="";

  constructor() { }

  ngOnInit(): void {
    this.anio=moment(moment.now()).format("YYYY");
  }

}
