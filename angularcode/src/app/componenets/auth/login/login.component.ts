import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../../services/auth-services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  error :string; 
  password: string;

  redirect_url:string = '';

  constructor(private router:Router, private authService:AuthService,private route:ActivatedRoute) { 
    this.route.queryParams.subscribe( (params)=>{
      if (params.page_redirect)
      {
        this.redirect_url = params.page_redirect;
      }
    })
  }

  ngOnInit(){}
    
  login() {
      this.error = '';
      this.authService.login(this.email,this.password)
      .subscribe(
        s=>this.router.navigate([this.redirect_url])
        ,e=>(this.error = e));
     }
    


}
