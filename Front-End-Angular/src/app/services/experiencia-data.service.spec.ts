import { TestBed } from '@angular/core/testing';

import { ExperienciaDataService } from './experiencia-data.service';

describe('ExperienciaDataService', () => {
  let service: ExperienciaDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExperienciaDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
