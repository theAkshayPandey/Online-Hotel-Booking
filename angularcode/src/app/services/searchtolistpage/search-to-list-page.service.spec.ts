import { TestBed } from '@angular/core/testing';

import { SearchToListPageService } from './search-to-list-page.service';

describe('SearchToListPageService', () => {
  let service: SearchToListPageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchToListPageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
