import { TestBed } from '@angular/core/testing';

import { SeccionDataService } from './seccion-data.service';

describe('SeccionDataService', () => {
  let service: SeccionDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeccionDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
