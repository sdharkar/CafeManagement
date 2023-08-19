import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { User } from 'src/model/user.model';
import { NgForm } from '@angular/forms';
import { UserAuthService } from '../service/user-auth.service';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  // users : User[] = [];
  // user : User = new User();

  loginData={
    username:'',
    password:''
  }

  constructor(private userService : UserService,
              private router: Router, 
              private userAuthService: UserAuthService,
              private login: LoginService
              ){}

  ngOnInit(): void {
  }

  formSubmit(){
    console.log("Login button clicked");

    if(this.loginData.username.trim()==''|| this.loginData.username==null){
      alert("Username is not valid")
    }
    if(this.loginData.password.trim()==''|| this.loginData.password==null){
      alert("Password is not valid")
    }

    this.login.generateToken(this.loginData).subscribe(
      (data:any)=>{
        console.log('success')
        console.log(data);

        //login...
        this.login.loginUser(data.token);

        this.login.getCurrentUser().subscribe(
          (user:any)=>{
            this.login.setUser(user);
            console.log(user);

            if(this.login.getUserRole()=="Admin"){

              window.location.href='/admin-dashboard'
            }else if(this.login.getUserRole()=="Customer"){
              window.location.href='/user-dashboard'
            }else{
              this.login.logout
            }
            
          }
        )

      },
      (error)=>{
        console.log('error');
        console.log(error)
      }
    )
  }

  // onSubmit(){
  //   console.log('Login successfully!!');
  // }


  // login(loginForm:NgForm){
  //   this.userService.login(loginForm.value).subscribe( (response:any) =>{
  //     console.log(response.jwtToken);
  //     console.log(response.user.role);

  //     this.userAuthService.setRoles(response.user.role);
  //     this.userAuthService.setToken(response.jwtToken);
  //     //console.log(response);
  //     const role = response.user.role[0].roleName;
  //     if(role === 'Admin'){
  //       this.router.navigate(['/dashboard']);
  //     } else {
  //       this.router.navigate(['/menu'])
  //     }
  //   },
  //   (error) => {
  //     console.error("Error in login", error);
  //   }
  //   );
  // }

}
