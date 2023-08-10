import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { User } from 'src/model/user.model';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  //URL for jwt authentication 
  private baseUrl6 = 'http://localhost:9617/api/jwt/auth';

  private baseUrl7 = 'http://localhost:9617/api/jwt/user'

  //To authenticate end points
  requestHeader = new HttpHeaders(
    {
      "No-Auth":"True"
    }
  )

  constructor(private http: HttpClient,
              private userAuthService :UserAuthService
              ) { }

  //Signup
  registerNewUser(user: User): Observable<User>{
    return this.http.post<User>(this.baseUrl7,user);
  }

  //login
  public login(loginData: any){
    return this.http.post(this.baseUrl6 + "/authenticate", loginData, {headers: this.requestHeader});
  }


  public forUser(){
    return this.http.get(this.baseUrl7 + '/foruser', {responseType:"text"});
  }

  public forAdmin(){
    return this.http.get(this.baseUrl7 + '/foradmin', {responseType:"text"});
  }

  public roleMatch(allowedRoles: string[]): boolean {
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();
  
    if (userRoles != null && userRoles.length > 0) {
      for (let i = 0; i < userRoles.length; i++) {
        for (let j = 0; j < allowedRoles.length; j++) {
          if (userRoles[i].roleName === allowedRoles[j]) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
        }
      }
    }
  
    return isMatch;
  }
  


}
