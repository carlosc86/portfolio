import { TestBed } from '@angular/core/testing';

import { PortfolioDTOService } from './portfolio-dto.service';

describe('PortfolioDTOService', () => {
  let service: PortfolioDTOService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PortfolioDTOService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
