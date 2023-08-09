import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from 'src/model/user.model';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user : User = new User();

  constructor(private userService: UserService, private router: Router){}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  signup(){
    this.userService.registerNewUser(this.user).subscribe( (response) =>{
      console.log("Signup Successful", response);
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
    (error) => {
      console.error('Error in signup',error);
    }
    );
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  onSubmit(){
    console.log("Signup successful!! ",this.user);
    this.signup();

  }
}
