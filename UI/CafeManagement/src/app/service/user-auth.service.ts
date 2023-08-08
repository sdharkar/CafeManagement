import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setRoles(roles:[]){
    localStorage.setItem("roles", JSON.stringify(roles));
  }

  // public getRoles():[]{
  //   return JSON.parse(localStorage.getItem('roles'));
  // }

  public getRoles(): string[] {
    const rolesString = localStorage.getItem('roles');
    if (rolesString !== null) {
      return JSON.parse(rolesString);
    } else {
      return []; // Return an empty array or handle the null case as needed
    }
  }
  

  public setToken(jwtToken: string){
    localStorage.setItem("jwtToken", jwtToken);
  }

  // public getToken(): string{
  //   return localStorage.getItem('jwtToken');
  // }

  public getToken(): string | null {
    const token = localStorage.getItem('jwtToken');
    return token !== null ? token : null;
  }
  

  public clear(){
    localStorage.clear();
  }

  public isLoggedIn(){
    return this.getRoles() && this.getToken();
  }


}
