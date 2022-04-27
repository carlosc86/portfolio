import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElementoBotonComponent } from './elemento-boton.component';

describe('ElementoBotonComponent', () => {
  let component: ElementoBotonComponent;
  let fixture: ComponentFixture<ElementoBotonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElementoBotonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ElementoBotonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
