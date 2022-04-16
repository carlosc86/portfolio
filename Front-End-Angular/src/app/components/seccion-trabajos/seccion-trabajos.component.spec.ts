import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeccionTrabajosComponent } from './seccion-trabajos.component';

describe('SeccionTrabajosComponent', () => {
  let component: SeccionTrabajosComponent;
  let fixture: ComponentFixture<SeccionTrabajosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeccionTrabajosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeccionTrabajosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
