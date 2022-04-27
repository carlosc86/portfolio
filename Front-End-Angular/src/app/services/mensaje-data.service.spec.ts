import { TestBed } from '@angular/core/testing';

import { MensajeDataService } from './mensaje-data.service';

describe('MensajeDataService', () => {
  let service: MensajeDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MensajeDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
