import { TestBed } from '@angular/core/testing';

import { BookingService } from '././bookingservice.service';

describe('BookingserviceService', () => {
  let service: BookingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
