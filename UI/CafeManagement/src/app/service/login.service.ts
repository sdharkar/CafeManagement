import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl='http://localhost:9000/customer';

  
  static login(inputData: { username: string; password: string; }) {
    throw new Error('Method not implemented.');
  }

  public getCurrentUser(){
    return this.http.get(`${this.baseUrl}/current-user`)
  }
  constructor(private http:HttpClient) { }

  //generate Token

  public generateToken(loginData:any){
    return this.http.post(`${this.baseUrl}/authenticate`,loginData)
      }

  //login user: set token in local storage
  public loginUser(token: string){
    localStorage.setItem("token",token);
    return true;
  }

  //islogin: user is login or not

  public isLoggedIn(){
    let tokenStr=localStorage.getItem("token");
    if(tokenStr==undefined || tokenStr==''|| tokenStr==null){
      return false;
    }
    else{
      return true
    }
  }
  //logout:remove token from local storage

  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    localStorage.removeItem('code');
    localStorage.removeItem('description');
    localStorage.removeItem('category');
    localStorage.removeItem('provider');

    return true;
  }

  //get token
  public getToken(){
    return localStorage.getItem('token');
  }

  //set userDetails

  public setUser(user:[]){
    localStorage.setItem('user',JSON.stringify(user));
  
  }
  public getUser(){
    let userStr=localStorage.getItem("user");
    if(userStr!=null){
      return JSON.parse(userStr);
    }else{
      this.logout();
      return null
    }
  }

  //get user role
  public getUserRole(){
    let user=this.getUser();
    return user.authorities[0].authority;
  }

  public clear(){
    localStorage.clear();
  }


}
