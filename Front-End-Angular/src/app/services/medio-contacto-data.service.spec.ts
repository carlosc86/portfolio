import { TestBed } from '@angular/core/testing';

import { MedioContactoDataService } from './medio-contacto-data.service';

describe('MedioContactoDataService', () => {
  let service: MedioContactoDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedioContactoDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
