import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GetHotelDetailService } from '../../services/hotel-detail-from-spring/get-hotel-detail.service'
import { AboutHotel } from 'src/app/model/about-hotel-details/about-hotel';
import { HotelRoomData } from 'src/app/model/hotel-and-room-details/hotel-room-data';
import { HotelFacilities} from '../../model/hotel-facilities/hotel-facilities';
import { Route } from '@angular/compiler/src/core';
import { AuthService } from 'src/app/services/auth-services/auth.service';
import { User } from 'src/app/model/user/user';

export interface HotelDetails {
  hotelname:string;
  hotellocation:string;
  hotelsublocation:string;
  hotelfacility:string[];
  hoteladdress:string;
  hotelrating:string;
}

// for initializing hoteldata variable
const hdata:HotelDetails = { hotelname:"",
                             hotellocation:"",
                             hotelsublocation:"",
                             hotelfacility:[],
                             hoteladdress:"",
                             hotelrating:""
                            } 


                            
export interface HotelImage {
  image: string;
  thumbImage:string;
  alt:string
}

const hotel_image_object:HotelImage[] = [{
  image: "assets/images/hotel_error_image.jpg",
  thumbImage:"assets/images/hotel_error_image.jpg",
  alt:"assets/images/hotel_error_image.jpg"
}]





export interface HotelFacilitiesDetail {
  facilityname:string;
  facilitydesc:String [];
}

const hfdata:HotelFacilitiesDetail[] = 
             [{ facilityname:"",
                facilitydesc:[] 
              }]




export interface SelectedRoom {
  room_id:number;
  room_name:string;
  room_price:number;
  included_facility:string;
  roomdetails:Array<Object>;
  roomthumbimg:string;
}



const edata: SelectedRoom[] = [
  { room_id:0,
   room_name: "",
   room_price: 0,
   included_facility:'',
   roomdetails:[],
   roomthumbimg:''}];




const AboutData:AboutHotel = {
  id:0,
  hotelid:0,
  description:'',
  checkintime:'',
  checkoutime:''
}


@Component({
  selector: 'app-hotel-detail',
  templateUrl: './hotel-detail.component.html',
  styleUrls: ['./hotel-detail.component.css']
})

export class HotelDetailComponent implements OnInit {

  //user 
  user: User;

  // just to capture hotel_id and room_id in one string
  room_hotel:string;

  abouthotel:AboutHotel = AboutData;
  hoteldetail:HotelRoomData[] = [];
  hotel_id:number;
  room_id:number;

  hotelfacility:HotelFacilitiesDetail[] = hfdata;


  // initialization of hoteldata
  hoteldata:HotelDetails = hdata;


  no_of_guest:number =JSON.parse(localStorage.getItem("favouriteData")).guestNo;


  // setting hotel-image-slider-variable
  dataSource:any= edata;


  totalcost:number = 0;
  selected_room:number[] = [];
  select_data:SelectedRoom[] = [];



  SendDataToBooking()
  {
    let room_id_list:number[] = []
    
    let array = this.select_data;
    for (let index = 0; index < array.length; index++) {
      const element = array[index];
      room_id_list.push(element.room_id)
    }
    let rlist = room_id_list.toString();
    let data_to_be_sent = {totalcost:this.totalcost,no_of_guest:this.no_of_guest,room_id_list:rlist}
    

  



    if (this.user)
    {
      this.router.navigate(['/booking'],{queryParams:{query_data:JSON.stringify(data_to_be_sent)} });
    }
    else
    {


      this.router.navigate(['/auth'],{queryParams:{page_redirect:this.router.url}});
    }




  }




 
// if no image found on room-thumb image default image will bw used
  onImgError(event) { 
    event.target.src = 'assets/images/room_error.jpg';
}


onSetImg1(event){
  event.target.set = 'assets/images/hotel_room_error.jpg'
}

onSetImg2(event){
  event.target.set = 'assets/images/hotel_room_error.jpg'
}

  // function from service to set hotel facility
  setHotelFacility(x:HotelFacilities[])
  {

    let array = x;
    let temp:HotelFacilitiesDetail[] = [];
    for (let index = 0; index < array.length; index++) {
      let x = { facilityname:array[index].facilityname, facilitydesc:array[index].facilitydesc.split(',')};
      temp.push(x);  
    }
    this.hotelfacility = temp;
    console.log(this.hotelfacility)

  }

  secondry_image_1:string = "";
  secondry_image_2:string = "";
  setHotelImages(x:any)
  {

    let array = x;
    if (array.length > 0)
    {
      if (array.length > 1 )
      {
        this.secondry_image_1 = array[0].imagepath;
        this.secondry_image_2 = array[1].imagepath;
      }
      else
      {
        this.secondry_image_1 = "assets/images/hotel_error_image.jpg"
        this.secondry_image_2 = "assets/images/hotel_error_image.jpg"
      }

      let temp:HotelImage[] = [];
      for (let index = 0; index < array.length; index++) {
        let single_image:HotelImage;
        single_image = { image: array[index].imagepath,
                         thumbImage:array[index].imagepath,
                         alt:"assets/images/hotel_error_image.jpg"}

        temp.push(single_image);
      }
    this.image_Array_Object = temp;
    }

    else
    {
    this.image_Array_Object = [{image: "assets/images/hotel_error_image.jpg",
                                thumbImage:"assets/images/hotel_error_image.jpg",
                                alt:"assets/images/hotel_error_image.jpg"}]

    this.secondry_image_1 = "assets/images/hotel_error_image.jpg"
    this.secondry_image_2 = "assets/images/hotel_error_image.jpg"
    }  
  }



  //function to set about hotel detail
  setAboutHotelDetail(abt_htl:AboutHotel)
  {
    this.abouthotel = abt_htl;
  }


  // setting up room-hotel-detail-common-function
  setHotelRooMDetail(data:HotelRoomData [])
  {



    if (data && data.length > 0)
    {
      // hotel details setting
      let temp = data[0];
      let poc = {
                 hotelname:temp.hotel_name,
                 hotellocation:temp.hotel_location,
                 hotelsublocation:temp.hotel_sub_location,
                 hotelfacility:temp.hotel_facilities.split(','),
                 hoteladdress:temp.hotel_address,
                 hotelrating:temp.hotel_rating
                };
      this.hoteldata = poc;

    }

    const array = data;

    //selected room logic
    let no_of_room_req:number;
    let guestNo = JSON.parse(localStorage.getItem("favouriteData")).guestNo; //no of guest
    let roomnNo = JSON.parse(localStorage.getItem("favouriteData")).roomnNo
    if (parseInt(roomnNo) == 1 && parseInt(guestNo) > roomnNo)
    {
      no_of_room_req = Math.ceil(parseInt(guestNo)/2);
    }
    else if (parseInt(guestNo) == 1 && parseInt(roomnNo) > guestNo)
    {
      no_of_room_req = parseInt(roomnNo);
    }

    no_of_room_req = parseInt(roomnNo);
    let sum_of_no_of_room = 1;


    


    // setting up hotel name, location, sub location
    // setting value in room_list
    let sum = 0;

    for (let index = 0; index < array.length; index++) {
      let room_var = 0;
    
      // for picking up
      if (sum_of_no_of_room <=  no_of_room_req)
      {
        this.selected_room.push(array[index].room_id);
        let sroom = { room_id:array[index].room_id,
                  room_name:array[index].room_name,
                  room_price:array[index].price,
                  included_facility:array[index].hotel_facilities,
                  roomdetails:array[index].roomdetails,
                  roomthumbimg:array[index].room_thumb_img
                };
        sum += array[index].price;
        this.select_data.push(sroom)
        room_var = 1;
      }
      sum_of_no_of_room+=1;
    }
    // total cost of the room
    this.totalcost = sum;
   
    // this.dataSource to show all the selected rooms
    this.dataSource = this.select_data;
  }





  constructor(private route:ActivatedRoute,private get_hotel_details:GetHotelDetailService,private router:Router,private authService: AuthService) { 
    this.hotel_id = +this.route.snapshot.paramMap.get("hid");
    this.room_id = +this.route.snapshot.paramMap.get("rid");
    this.room_hotel = this.hotel_id+"_"+this.room_id


    this.authService.findMe().subscribe((user) => { this.user = user;
    });



  }

  // for setting up the table fields
  displayedColumns: string[] = ["ROOM_TYPE", "INCLUDED_IN_THIS_PRICE", "PRICE"];
  
  // all images list now getting from db
  image_Array_Object:HotelImage[] = hotel_image_object;

  // need to make this dynamic , actually we dont need it since we will get it from db
  imageObject: Array<object> = 
  [
    {
    image: 'assets/images/hotelimg/img1.jpg',
    thumbImage: 'assets/images/hotelimg/img1.jpg',
    alt: 'alt of image',
    title: 'title of image'
    }, {
      image: 'assets/images/hotelimg/img2.jpg',
      thumbImage: 'assets/images/hotelimg/img2.jpg',
      alt: 'alt of image',
      title: 'title of image'
      },
    {
      image: 'assets/images/hotelimg/img3.jpg',
      thumbImage: 'assets/images/hotelimg/img4.jpg',
      alt: 'alt of image',
      title: 'title of image'
    },
    {
      image: 'assets/images/hotelimg/img4.jpg',
      thumbImage: 'assets/images/hotelimg/img4.jpg',
      alt: 'alt of image',
      title: 'title of image'
    }
  ];


  initializing_cost()
  {
    let array = this.select_data;
    let sum = 0;
    for (let index = 0; index < array.length; index++) {
      sum+= array[index]["room_price"];
    }
    this.totalcost = sum;
  }


  ngOnInit(): void {

    this.initializing_cost();

    // common-room-hotel-details
    this.get_hotel_details.getHotelRoomCommonDetails(this.room_hotel).subscribe((x:any)=>{
      this.setHotelRooMDetail(x);
    })

    // about-hotel-detail
    this.get_hotel_details.getAboutHotel(this.hotel_id).subscribe((data:any)=>{
      this.setAboutHotelDetail(data);
    },(error)=>{
      console.log("could not get hotel facilities ",error)
    });

    // hotel-facilities
    this.get_hotel_details.getHotelFacility(this.hotel_id).subscribe((data:any)=>{
      this.setHotelFacility(data);
    },(error)=>{
      console.log("could not get hotel facilities ",error)
    });

     // hotel-images
     this.get_hotel_details.getHotelImages(this.hotel_id).subscribe((data:any)=>{
      this.setHotelImages(data);
     },(error)=>{
       console.log("could not load images ",error);

    });


  }

}
