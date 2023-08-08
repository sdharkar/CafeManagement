import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { User } from 'src/model/user.model';
import { NgForm } from '@angular/forms';
import { UserAuthService } from '../service/user-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  users : User[] = [];
  user : User = new User();

  constructor(private userService : UserService,
              private router: Router, 
              private userAuthService: UserAuthService
              ){}

  ngOnInit(): void {
      
  }

  onSubmit(){
    console.log('Login successfully!!');
  }


  login(loginForm:NgForm){
    this.userService.login(loginForm.value).subscribe( (response:any) =>{
      console.log(response.jwtToken);
      console.log(response.user.role);

      this.userAuthService.setRoles(response.user.role);
      this.userAuthService.setToken(response.jwtToken);
      //console.log(response);
      const role = response.user.role[0].roleName;
      if(role === 'Admin'){
        this.router.navigate(['/dashboard']);
      } else {
        this.router.navigate(['/menu'])
      }
    },
    (error) => {
      console.error("Error in login", error);
    }
    );
  }

}
