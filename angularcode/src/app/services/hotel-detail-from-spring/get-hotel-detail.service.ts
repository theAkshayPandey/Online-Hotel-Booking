import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HotelRoomId } from 'src/app/model/hotel-room-id/hotel-room-id';



const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class GetHotelDetailService {

   constructor(private http:HttpClient) { }

  
   // hotel-room-common-details
   getHotelRoomCommonDetails(room_hotel_ids:string):Observable<any>{
    let data = JSON.parse(localStorage.getItem('favouriteData')) ;  
    data["hotel_id"] = parseInt(room_hotel_ids.split('_')[0]);
    data["room_id"] = parseInt(room_hotel_ids.split('_')[1]);
    let url:any = "http://localhost:8001/hotel-detail";    
    return this.http.post<any>(url,data);
  }


  // about-hotel-data
  getAboutHotel(id:number):Observable<any>{
    let url:any =`http://localhost:8001/about-hotel?id=${id}`;
    return this.http.get<any>(url);
  }


  // hotel-facility
  getHotelFacility(id:number):Observable<any>{
    let url:any =`http://localhost:8001/facility-hotel?id=${id}`;
    return this.http.get<any>(url);
  }


  // hotel-images
  getHotelImages(id:number):Observable<any>{
    let url:any =`http://localhost:8001/images-hotel?id=${id}`;
    return this.http.get<any>(url);
  }



}
