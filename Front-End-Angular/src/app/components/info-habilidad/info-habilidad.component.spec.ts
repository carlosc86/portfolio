import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoHabilidadComponent } from './info-habilidad.component';

describe('InfoHabilidadComponent', () => {
  let component: InfoHabilidadComponent;
  let fixture: ComponentFixture<InfoHabilidadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoHabilidadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoHabilidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
