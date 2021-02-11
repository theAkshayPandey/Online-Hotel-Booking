import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule,HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchToListPageService {
  public data: any;
  constructor(private http:HttpClient) { }

  

  getHotelList():Observable<any>{
    // in string format converting to JSON
    let data = JSON.parse(localStorage.getItem('favouriteData'));
    let url:any = "http://localhost:8001/get-hotel-list";
    return this.http.post<any>(url,data);
  }
}
