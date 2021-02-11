import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user/user';
import { AuthService } from '../../services/auth-services/auth.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  // myimg:string= 'assets/images/hotelkat.PNG';

  myimg:string= 'assets/images/hotelkatcroped.png';


  user: User;
  userSubscription: Subscription;

  constructor(private authService: AuthService,
    private router: Router) {
  
    this.authService.findMe().subscribe((user) => {
      this.user = user;
      console.log(user);
    });

    this.userSubscription = this.authService.user.subscribe((user) => {
      this.user = user;
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/']);
  }

  ngOnDestroy(): void {
    if (this.userSubscription) {
      this.userSubscription.unsubscribe();
    }
  }





  ngOnInit(): void {
  }

}
