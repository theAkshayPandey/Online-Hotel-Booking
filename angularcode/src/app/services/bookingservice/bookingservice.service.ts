import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http:HttpClient) {

  }
   /*
   private apiUrl;

   getbookings(bookingdata:any){
     console.log(JSON.stringify(bookingdata));
     return this.http.post<any>( `${this.apiUrl}booking`,bookingdata);
   }*/


   bookRooms(data:any){
    let url:any = "http://localhost:8001/book";
    return this.http.post<any>(url,data);
   }

}
