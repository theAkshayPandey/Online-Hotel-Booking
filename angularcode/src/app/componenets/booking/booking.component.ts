import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormBuilder } from '@angular/forms';
import { BookingService } from 'src/app/services/bookingservice/bookingservice.service';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth-services/auth.service';
import { User } from 'src/app/model/user/user';
import { ActivatedRoute, Router } from '@angular/router';
import { BookStatus } from 'src/app/model/bookingstatus/book-status';

export interface ReqData{
  totalcost:number;
  no_of_guest:number;
  room_id_list:string;
}

interface RoomSelect {
  value: number;
  noOfRoom: number;
}

interface GuestSelect {
  value: number;
  noOfGuest: number;
}


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css'],
})

export class BookingComponent implements OnInit {
  user: User;

  // data to be sent to service
  req_data:ReqData = null;

  roomSelect:RoomSelect[] = [
    {value:1,noOfRoom:1},
    {value:2,noOfRoom:2},
    {value:3,noOfRoom:3},
    {value:4,noOfRoom:4},
    {value:5,noOfRoom:5},
    {value:6,noOfRoom:6}
  ];

  guestSelect:GuestSelect[] = [
    {value:1,noOfGuest:1},
    {value:2,noOfGuest:2},
    {value:3,noOfGuest:3},
    {value:4,noOfGuest:4},
    {value:5,noOfGuest:5},
    {value:6,noOfGuest:6}
  ];

  // user id
  user_id:number = 0;


  totalPrice: any;
  total: any;
  GST = 0.18;
  basePrice = 1234;
  days;
  rooms;
 
  bookingForm = this.fb.group({
    name: new FormControl({value:'',disabled: true},[Validators.required]),
    email: new FormControl({value:'',disabled: true},[Validators.required , Validators.email]),
    phoneNo: new FormControl('', [Validators.required,Validators.maxLength(20)]),
    address: new FormControl('',[Validators.required,Validators.maxLength(200)]),
    country: new FormControl('', [Validators.required,Validators.maxLength(50)]),
    state: new FormControl('', [Validators.required,Validators.maxLength(50)]),
    zipCode: new FormControl('',[Validators.required,Validators.maxLength(50)]),
    entryDate: new FormControl({value:'',disabled: true}, [Validators.required]),
    exitDate: new FormControl({value:'',disabled: true},[Validators.required]),
    roomNo: new FormControl({value:'',disabled: true},[Validators.required]),
    guest: new FormControl({value:'',disabled: true},[Validators.required])
    
  });

  minDate: Date;
  minDatep: Date;
  maxDate: Date;
  book;
  person:number;
  price:number;
  hotel;
  userSubscription: Subscription;
  data;

  constructor(private bookservice: BookingService,
                    private authService: AuthService, private fb: FormBuilder,private router: Router,private route:ActivatedRoute) { 
    
       this.data = JSON.parse(localStorage.getItem('favouriteData'));
      
      if (this.data)
      {                  
        this.authService.findMe().subscribe((user) => { this.user = user
      
        // form details

          let user_name = "";
          let user_email = "";
      
          if (this.user && this.user.name && this.user.email)
          {
              user_name = this.user.name
              user_email = this.user.email
          }
          // [totalPrice=300, roomIdList=7, address=asdasd, Country=asdasd, entryDate=null,
          // exitDate=null, guest=0, phoneNo=asdasdasd, roomNo=0, state=asdasd, zipCode=asdasddas,
          // sname=null, email=null]



          //seting up default values
          this.bookingForm.setValue({
              name: user_name,
              email: user_email,
              phoneNo: '',
              address: '',
              country: '',
              state: '',
              zipCode:'',
              entryDate: this.data.checkin,
              exitDate: this.data.checkout,
              roomNo: this.data.roomnNo,
              guest: this.data.guestNo
          });
      
        });
      }
      else
      {
          alert("Booking Form Invalid")
          this.router.navigate(['']);
      }
  }
  
  ngOnInit(): void {

    this.route.queryParams.subscribe((params)=>{
      if (params != null)
      {
        this.req_data = JSON.parse(params.query_data)
        this.basePrice = this.req_data.totalcost;
      }
    })




    this.days = this.calculateDays(this.data);
    this.rooms=this.data.roomnNo;



    //this.basePrice=;
    this.totalPrice = this.basePrice * this.days;
    this.GST = this.GST * this.totalPrice;
    this.total = this.totalPrice + this.GST;
    

  }

  //calculate no of days
  calculateDays(data): number {


    var date1:any = new Date(data.checkin);
    var date2:any = new Date(data.checkout);
    var diffDays:any = Math.ceil((date2 - date1) / (1000 * 60 * 60 * 24));

    return diffDays;

  }

  bookNow(){
    if(this.bookingForm.invalid)
      {
         alert("Booking Form Invalid !");

      }
      else
      {     

      let new_list = this.bookingForm.getRawValue();

      // manually making key value pair
      new_list["totalPrice"] = this.req_data.totalcost;
      new_list["roomIdList"] = this.req_data.room_id_list;
      new_list["userId"] = this.user_id;



      this.bookservice.bookRooms(new_list).subscribe( (result:BookStatus)=>{

        if (result && result.insert_status)
        {
          this.router.navigate(['/confirm'],{queryParams:{query_data:JSON.stringify(result)}});
        }
        else
        {
          this.router.navigate(['/fail']);
        }
      })
   }
  }

  //restric check-out date
  updateCalcs(){
  const book = this.bookingForm.getRawValue();
  const minDatex = new Date(book.checkin); 
  minDatex.setDate(minDatex.getDate() + 1);
  this.minDatep = new Date(minDatex);
  }

  cancel() {
    this.router.navigate(['/']);
}
}
