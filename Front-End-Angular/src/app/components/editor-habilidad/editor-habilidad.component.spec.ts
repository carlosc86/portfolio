import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorHabilidadComponent } from './editor-habilidad.component';

describe('EditorHabilidadComponent', () => {
  let component: EditorHabilidadComponent;
  let fixture: ComponentFixture<EditorHabilidadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorHabilidadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorHabilidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
