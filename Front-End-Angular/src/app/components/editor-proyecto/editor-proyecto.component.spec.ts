import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorProyectoComponent } from './editor-proyecto.component';

describe('EditorProyectoComponent', () => {
  let component: EditorProyectoComponent;
  let fixture: ComponentFixture<EditorProyectoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorProyectoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorProyectoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
