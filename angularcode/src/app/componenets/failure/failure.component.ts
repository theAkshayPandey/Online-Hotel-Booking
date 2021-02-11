import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-failure',
  templateUrl: './failure.component.html',
  styleUrls: ['./failure.component.css']
})
export class FailureComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {


    // add something here
    localStorage.removeItem('favouriteData');

  }


  cancel() {
    this.router.navigate(['/']);
}

}
