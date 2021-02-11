import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../../services/auth-services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  userForm = new FormGroup({
    name: new FormControl('',[Validators.required]),
    email: new FormControl('',[Validators.required , Validators.email]),
    password: new FormControl('',[Validators.required]),
    repeatPassword: new FormControl('',[Validators.required, this.passwordMatch])
  });


  constructor(private router:Router, private authService:AuthService) { 
    // console.log('userform',this.userForm)
  }

  passwordMatch(control: FormControl){
    const password = control.root.get('password');
    return password && control.value !== password.value
    ?
      {
        passwordMatch:true
      }
    :   null;
  }

  ngOnInit() {}
  
  register(){
  if(!this.userForm.valid) {
      return;
    }  
    const user=this.userForm.getRawValue();
    this.authService.register(user)
    .subscribe(s=>this.router.navigate(['/']));
  }

 
  get name(){
    return this.userForm.get('name');
  }
  get email(){
    return this.userForm.get('email');
  }
  get password(){
    return this.userForm.get('password');
  }
  get repeatPassword(){
    return this.userForm.get('repeatPassword');
  }
}
