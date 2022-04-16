import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeccionAcercaDeComponent } from './seccion-acerca-de.component';

describe('SeccionAcercaDeComponent', () => {
  let component: SeccionAcercaDeComponent;
  let fixture: ComponentFixture<SeccionAcercaDeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeccionAcercaDeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeccionAcercaDeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
