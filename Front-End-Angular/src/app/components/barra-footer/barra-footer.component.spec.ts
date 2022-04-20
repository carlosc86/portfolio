import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraFooterComponent } from './barra-footer.component';

describe('BarraFooterComponent', () => {
  let component: BarraFooterComponent;
  let fixture: ComponentFixture<BarraFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BarraFooterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BarraFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
