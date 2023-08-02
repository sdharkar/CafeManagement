import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { User } from 'src/model/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  users : User[] = [];
  user : User = new User();

  constructor(private userService : UserService, private router: Router){}

  ngOnInit(): void {
      
  }

  onSubmit(){
    console.log('Login successfully!!');
  }

}
