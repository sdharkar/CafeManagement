import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit{

  message: any;

  constructor(private userService: UserService){}

  ngOnInit(): void {
    this.forUser();
  }

  forUser(){
    this.userService.forUser().subscribe(
      (response) =>{
        console.log(response);
        this.message = response;
      },
      (error) => {
        console.error('Error in for user', error);
      }
    );
  }
    
      

}

