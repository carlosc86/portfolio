import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoMedioContactoComponent } from './info-medio-contacto.component';

describe('InfoMedioContactoComponent', () => {
  let component: InfoMedioContactoComponent;
  let fixture: ComponentFixture<InfoMedioContactoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoMedioContactoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoMedioContactoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
