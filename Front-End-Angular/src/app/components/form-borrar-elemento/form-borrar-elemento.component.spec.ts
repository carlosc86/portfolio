import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormBorrarElementoComponent } from './form-borrar-elemento.component';

describe('FormEliminarElementoComponent', () => {
  let component: FormBorrarElementoComponent;
  let fixture: ComponentFixture<FormBorrarElementoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormBorrarElementoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormBorrarElementoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
