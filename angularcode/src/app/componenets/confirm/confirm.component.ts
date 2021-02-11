import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
export interface PeriodicElement {
  bookingid: number;
  status: string;
}

const ELEMENT_DATA: PeriodicElement[] = [{bookingid: 0 ,status: "Failed"},]


@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent implements OnInit {

  displayedColumns: string[] = ['bookingid', 'status'];
  dataSource = ELEMENT_DATA;


  constructor(private router: Router,private route:ActivatedRoute) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe( (params)=>{
      let bksts = "Failed";
      let booking_data = JSON.parse(params.query_data);
      console.log(booking_data)

      if (booking_data.status == 1)
      {
        bksts = "Confirmed";
      }
      this.dataSource = [{bookingid: booking_data.booking_id ,status: bksts}]; 


      localStorage.removeItem('favouriteData');


    })


  }

}
