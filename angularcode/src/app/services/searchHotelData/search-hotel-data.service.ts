import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import { debounceTime, map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class SearchHotelDataService {

  constructor(private http:HttpClient) { }


  storeinLocalStorage(data:any):Observable<any>{
    let status  =true ;
    if (localStorage.getItem('favouriteData') && localStorage.getItem('favouriteData').length > 0)
    {
      localStorage.removeItem('favouriteData');
      localStorage.setItem('favouriteData', JSON.stringify(data));  
      status  =true
    }
    else
    {
      localStorage.setItem('favouriteData', JSON.stringify(data));
      status  =true
    }
    return of(status);
  }



  getLocationList():Observable<any>  {
    let url:any = "http://localhost:8001/get-location";
    return this.http.get<any>(url);

  }





}
