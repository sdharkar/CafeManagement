import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../service/user-auth.service';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{

  constructor(private userAuthService :UserAuthService,
              private router :Router,
              public loginService: LoginService
              ){}

  ngOnInit(): void {
      
  }

  public logout(){
    this.loginService.clear();
    this.router.navigate(['/home']);
  }

  

}
