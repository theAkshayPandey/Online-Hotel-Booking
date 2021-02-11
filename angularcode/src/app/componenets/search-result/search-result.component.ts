import { Component, OnInit } from '@angular/core';
import { SearchToListPageService } from '../../services/searchtolistpage/search-to-list-page.service';
import { HotelDetail} from '../../model/hoteldata/hotel-detail';


export interface SelectedLocality {
  locality:string;
  isChecked:boolean;
}

export interface SelectedStar {
  star:string;
  isChecked:boolean;
}

export interface SelectedProperty {
  property:string;
  isChecked:boolean;
}



const locality_initialization_var: SelectedLocality[] = [
  {locality:'',isChecked:false},
];

const star_initialization_var: SelectedStar[] = [
  {star:'',isChecked:false},
];

const property_initialization_var: SelectedProperty[] = [
  {property:'',isChecked:false},
];





@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {

  // if no data found or some error
  no_data_message:string= ""  
  data_available:boolean = true;




  // here we are storing entire list
  hoteldatalist:HotelDetail[] = [];





  //PIPE FILTERS VARIABLES
  // using pipe filter by hotel name
  HotelName:string = '';
  sublocation:SelectedLocality[] = locality_initialization_var;
  selectedItemsList = [];
  checkedLocation = [];

  propertytypelist:SelectedProperty[] = property_initialization_var;
  selectedPropertyList = [];
  checkedProperty = [];

  totalstarlist:SelectedStar[] = star_initialization_var;
  selectedStarList = [];
  checkedStar = [];



 // pipe operator function for locality,star,property
 changeSelection(operation:string) {
  this.fetchCheckedItems(operation)  
}


// on input checkbox change add items in respected checked array
fetchCheckedItems(checked_item:string) {
  if (checked_item === 'location')
  {
    this.checkedLocation = []
   
    this.sublocation.forEach((value, index) => {
      if (value.isChecked) {
        this.checkedLocation.push(value.locality);
      }
    });

  } else if (checked_item === 'property')
  {
    this.checkedProperty = []
   
    this.propertytypelist.forEach((value, index) => {
      if (value.isChecked) {
        this.checkedProperty.push(value.property);
      }
    });
  } else if ( checked_item === 'star')
  {
    this.checkedStar = []
   
    this.totalstarlist.forEach((value, index) => {
      if (value.isChecked) {
        this.checkedStar.push(value.star);
      }
    });
  }
}
// remove duplicates
remove_duplicated_star(arr:SelectedStar[],type:string)
{ 
    return  [...new Map(arr.map(item => [item[type],item])).values()]
}

remove_duplicated_property(arr:SelectedProperty[],type:string)
{ 
    return  [...new Map(arr.map(item => [item[type],item])).values()]
}

remove_duplicated_location(arr:SelectedLocality[],type:string)
{ 
    return  [...new Map(arr.map(item => [item[type],item])).values()]
}


// function to store hoteldata from service
  storehoteldata(data:HotelDetail[])
  {
    this.hoteldatalist = data;
    if (this.hoteldatalist && this.hoteldatalist.length > 1)
    {
      let store_sub_location_array:SelectedLocality[] = [];
      let store_hotel_type_array:SelectedProperty[] = [];
      let store_hotel_rating_array:SelectedStar[] = []
  
  
      for (let index = 0; index < this.hoteldatalist.length; index++) {
        store_sub_location_array.push({locality:this.hoteldatalist[index]["sub_location"],isChecked:false});
        store_hotel_type_array.push({property:this.hoteldatalist[index]["hotel_type"],isChecked:false});
        store_hotel_rating_array.push({star:this.hoteldatalist[index]["hotel_rating"],isChecked:false});
      }                    
    
      this.totalstarlist = this.remove_duplicated_star(store_hotel_rating_array,"star") ;
      this.sublocation = this.remove_duplicated_location(store_sub_location_array,"locality");      
      this.propertytypelist = this.remove_duplicated_property(store_hotel_type_array,"property");
    }  
  }


  constructor(private _data: SearchToListPageService, private searchpageserv: SearchToListPageService) { 
  }

  ngOnInit(): void {

     
    
    //service to get hotel-listing-using
    this.searchpageserv.getHotelList().subscribe((list_of_hotel:HotelDetail[]) => {    
        this.storehoteldata(list_of_hotel);

        this.data_available = true;
    },(error)=> {
        this.no_data_message =`${error.name} That’s an error. No data Found`;
        this.data_available =false;
        console.log("error from server side spring-boot");
    });

     
  }

}
