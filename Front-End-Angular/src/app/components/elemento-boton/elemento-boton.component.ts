import { Component, Input, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-elemento-boton',
  templateUrl: './elemento-boton.component.html',
  styleUrls: ['./elemento-boton.component.css']
})
export class ElementoBotonComponent implements OnInit {
  @Input() imagen="";
  @Input() target="";
  @Input() estilo?="";

  constructor(private authService:AuthenticationService) { }

  ngOnInit(): void {
  }

  visible():boolean{
    return this.authService.isLogin();
  }

}
