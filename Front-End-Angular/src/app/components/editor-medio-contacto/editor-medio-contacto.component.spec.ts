import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorMedioContactoComponent } from './editor-medio-contacto.component';

describe('EditorMedioContactoComponent', () => {
  let component: EditorMedioContactoComponent;
  let fixture: ComponentFixture<EditorMedioContactoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorMedioContactoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorMedioContactoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
