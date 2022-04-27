import { TestBed } from '@angular/core/testing';

import { HabilidadDataService } from './habilidad-data.service';

describe('HabilidadDataService', () => {
  let service: HabilidadDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HabilidadDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
