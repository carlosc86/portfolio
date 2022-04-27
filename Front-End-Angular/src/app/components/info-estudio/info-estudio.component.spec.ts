import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoEstudioComponent } from './info-estudio.component';

describe('InfoEstudioComponent', () => {
  let component: InfoEstudioComponent;
  let fixture: ComponentFixture<InfoEstudioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoEstudioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoEstudioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
