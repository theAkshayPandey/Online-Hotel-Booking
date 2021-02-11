import { TestBed } from '@angular/core/testing';

import { SearchHotelDataService } from './search-hotel-data.service';

describe('SearchHotelDataService', () => {
  let service: SearchHotelDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchHotelDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
