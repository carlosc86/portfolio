import { TestBed } from '@angular/core/testing';

import { EstudioDataService } from './estudio-data.service';

describe('EstudioDataService', () => {
  let service: EstudioDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EstudioDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
