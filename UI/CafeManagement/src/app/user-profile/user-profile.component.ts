import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { User } from 'src/model/user.model';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  users: User[] = [];

  user: User = new User();

  message: any;

  constructor(private loginService: LoginService, private userService: UserService) { }

  ngOnInit(): void {
    this.loadUser();
  }

  loadUser() {
    this.userService.getCurrentUser().subscribe(data => {
      this.user = data;
      console.log("get the current user", data);
    }, error => {
      console.error("Error in getting the current user", error)
    });
  }



}

