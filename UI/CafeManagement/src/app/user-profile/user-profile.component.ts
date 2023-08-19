import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit{

  message: any;

  constructor(private loginService: LoginService){}

  ngOnInit(): void {
    this.forUser();
  }

  forUser(){
  }
    
      

}

