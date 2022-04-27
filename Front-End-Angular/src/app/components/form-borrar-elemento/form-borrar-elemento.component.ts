import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-form-borrar-elemento',
  templateUrl: './form-borrar-elemento.component.html',
  styleUrls: ['./form-borrar-elemento.component.css']
})
export class FormBorrarElementoComponent implements OnInit {

  @Output() confirmar:EventEmitter<boolean>=new EventEmitter<boolean>();

  @Input() elemento:string="";

  constructor() { }

  ngOnInit(): void {
  }

  aceptar(){
    this.confirmar.emit(true);
  }

  

}
