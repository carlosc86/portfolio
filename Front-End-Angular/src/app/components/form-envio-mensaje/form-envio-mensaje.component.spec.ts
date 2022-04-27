import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormEnvioMensajeComponent } from './form-envio-mensaje.component';

describe('FormEnvioMensajeComponent', () => {
  let component: FormEnvioMensajeComponent;
  let fixture: ComponentFixture<FormEnvioMensajeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormEnvioMensajeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormEnvioMensajeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
