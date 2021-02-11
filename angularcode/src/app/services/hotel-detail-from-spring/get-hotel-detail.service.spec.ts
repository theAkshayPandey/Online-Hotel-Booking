import { TestBed } from '@angular/core/testing';

import { GetHotelDetailService } from './get-hotel-detail.service';

describe('GetHotelDetailService', () => {
  let service: GetHotelDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetHotelDetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
