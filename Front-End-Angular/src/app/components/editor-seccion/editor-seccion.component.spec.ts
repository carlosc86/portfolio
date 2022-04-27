import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorSeccionComponent } from './editor-seccion.component';

describe('EditarSeccionComponent', () => {
  let component: EditorSeccionComponent;
  let fixture: ComponentFixture<EditorSeccionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorSeccionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorSeccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
