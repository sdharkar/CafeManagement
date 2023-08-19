import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from 'src/model/user.model';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Location } from '@angular/common';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  // user : User = new User();

  constructor(private userService: UserService,
              private router: Router,
              private location: Location){}

  ngOnInit(): void {}
  public user={
    username:'',
    password:'',
    name:'',
    address:'',
    email:'',
    phone:'',
  }
  
    formSubmit(){
      console.log(this.user);
      if(this.user.username==''||this.user.username==null){
        Swal.fire('Username is required!')
        return;
      }
  
      console.log(this.user);
      if(this.user.password==''|| this.user.password==null){
        Swal.fire('Password is required!')
        return;
      }
  
      console.log(this.user);
      if(this.user.email==''|| this.user.email==null){
        Swal.fire('Email is required!')
        return;
      }
  
      console.log(this.user);
      if(this.user.name==''|| this.user.name==null){
        Swal.fire('Name is required!')
        return;
      }
  
      console.log(this.user);
      if(this.user.address==''|| this.user.address==null){
        Swal.fire('Address is required!')
        return;
      }
  
      console.log(this.user);
      if(this.user.phone==''|| this.user.phone==null){
        Swal.fire('Mobile Number is required!')
        return;
      }
  
      this.userService.addCustomer(this.user).subscribe(
        (data)=>{
          console.log(data);
          //Dialog box
          Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Signup successfully!!!',
          showConfirmButton: false,
          timer: 1500
          })
          this.goToLogin();

        },
        (error)=>{
          console.log(error);
          Swal.fire('Invalid form submission');
        }
      )
    }


    reloadPage() {
      this.location.replaceState;
    } 
    
    goToLogin() {
      this.router.navigate(['/login']);
    }


    
  }
