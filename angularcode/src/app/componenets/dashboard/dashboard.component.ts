import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup,Validators,AbstractControl ,ValidationErrors,ValidatorFn } from '@angular/forms';
import {Observable} from 'rxjs';
import {debounceTime, map, startWith, switchMap} from 'rxjs/operators';
import { SearchHotelDataService } from '../../services/searchHotelData/search-hotel-data.service';
import { SearchData} from '../../model/searchData/search-data';
import { Router } from '@angular/router';

  interface RoomSelect {
    value: number;
    noOfRoom: number;
  }
  interface GuestSelect {
    value: number;
    noOfGuest: number;
  }
  


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})




export class DashboardComponent implements OnInit {
  // list_of_city: string[] = ['Delhi', 'Bangalore'];
  list_of_city: string[] = [];


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


  // filteredOptions: Observable<string[]>;
  filteredOptions: Array<string>;

  searchForm:FormGroup;

  
  autoComponent:FormControl = new FormControl();
  checkin:FormControl = new FormControl(new Date());
  checkout:FormControl = new FormControl('');
  guestNo:FormControl = new FormControl();
  roomnNo:FormControl = new FormControl();
  minDate: Date;
  minDatep: Date;
  maxDate: Date;
  icon: boolean = false;


  searchItem:SearchData;


  
  
  //room and guest logic initialization
  no_of_room:number = 1;
  no_of_guest:number = 1;
  


  //form
  str:string;
initialzeForm()
{
  this.searchForm = new FormGroup ({
    'autoComponent':new FormControl(this.list_of_city[0],Validators.required),
    'checkin':new FormControl(new Date(),Validators.required),
    'checkout':new FormControl(this.minDatep,Validators.required),
    'guestNo':new FormControl(this.no_of_guest,Validators.required),
    'roomnNo':new FormControl(this.no_of_room,Validators.required)
    }
  );
}


  

  someMethod(val)
  {
    let no_of_room:number[] = [1];
    if (val)
    {

      if (val == 1)
      {
        no_of_room = [1]; 
      }
      else if(val == 2)
      {
        no_of_room = [1,2]; 
      }
      else if(val == 3)
      {
        no_of_room = [2,3]; 
      }      
      else if(val == 4)
      {
        no_of_room = [2,3,4]; 
      }      
      else if(val == 5)
      {
        no_of_room = [3,4,5]; 
      }
      else if (val == 6)
      {
        no_of_room = [3,4,5,6];
      }

    }
    return no_of_room;
  }



  click(){
    this.icon = !this.icon;
  }


  updateCalcs(){
    
    const minDatex = new Date(this.checkin.value); 
    minDatex.setDate(minDatex.getDate() + 1);
    this.minDatep = new Date(minDatex);
  }

  onSubmit(){
    

    this.searchItem =  this.searchForm.value;
    let autocom = this.searchItem.autoComponent;

    if (!this.list_of_city.includes( String(autocom) ) )
    {
      this.searchForm.controls.autoComponent.setErrors({errmsg:"Select destination from the list."}) 
    }

    if ( this.searchItem.checkout < this.searchItem.checkin )
    {
      this.searchForm.controls.checkout.setErrors({errmsg:"Checkout Date cannot be smaller than Checkin Date"}) 
    }

    let list_of_room_possible = [];
    list_of_room_possible = this.someMethod(this.searchItem.guestNo)
    // console.log("guest_no" +this.searchItem.guestNo );
    
    if (!list_of_room_possible.includes(this.searchItem.roomnNo))
    {
      this.searchForm.controls.roomnNo.setErrors({errmsg:"Number Of Rooms Selected Invalid!"}) 
    }

    

    if (this.searchForm.valid)
    {
      this.hotelListServ.storeinLocalStorage(this.searchItem).subscribe((status:any) => {
        if (status)
        {
          this.router.navigate(['search-result']);
        }
      });

    }
  }

  gethotelLocationList(event:KeyboardEvent)
  { 
    this.filteredOptions = this.list_of_city.filter(
      (data)=> { 
                let str2;
                if (this.str)
                {
                  str2 = this.str.toLowerCase();
                }
                if (this.str && this.str.length > 1 && data.toLowerCase().includes(str2))
                {
                  return data;
                }
      });
 
  }
  

  constructor(private hotelListServ:SearchHotelDataService,private router: Router) {

    this.searchItem = new SearchData();
    
    const currentYear = new Date();
    this.minDate = new Date(currentYear);
    
    
    const currentYear1 = new Date().getFullYear();
    this.maxDate= new Date(currentYear1 +1,11,20);
    
    currentYear.setDate(currentYear.getDate() + 1);
    this.minDatep = new Date(currentYear);
    
    
  


   }

  ngOnInit(): void {
    this.initialzeForm();
    this.hotelListServ.getLocationList().subscribe((data:any) => {
      this.list_of_city = data;
    });
  }



  



  //this was made dynamic

  // private _filter(value: string): string[] {

  //   console.log()
  //   const filterValue = value.toLowerCase();
  //   return this.list_of_city.filter(option => option.toLowerCase().indexOf(filterValue) === 0);
  // }

 




}
