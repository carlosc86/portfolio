import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorEstudioComponent } from './editor-estudio.component';

describe('EditarEstudioComponent', () => {
  let component: EditorEstudioComponent;
  let fixture: ComponentFixture<EditorEstudioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorEstudioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorEstudioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
