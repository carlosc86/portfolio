import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormLecturaMensajeComponent } from './form-lectura-mensaje.component';

describe('FormLecturaMensajeComponent', () => {
  let component: FormLecturaMensajeComponent;
  let fixture: ComponentFixture<FormLecturaMensajeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormLecturaMensajeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormLecturaMensajeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
