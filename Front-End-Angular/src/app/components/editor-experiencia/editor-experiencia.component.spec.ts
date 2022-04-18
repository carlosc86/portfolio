import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorExperienciaComponent } from './editor-experiencia.component';

describe('EditorExperienciaComponent', () => {
  let component: EditorExperienciaComponent;
  let fixture: ComponentFixture<EditorExperienciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorExperienciaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorExperienciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
