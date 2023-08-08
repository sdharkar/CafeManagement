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

  //private baseUrl5='http://localhost:9614/api/user';

  //To authenticate end points
  requestHeader = new HttpHeaders(
    {
      "No-Auth":"True"
    }
  )

  constructor(private http: HttpClient,
              private userAuthService :UserAuthService
              ) { }

  // //Create user
  // createUser(user: User): Observable<User>{
  //   return this.http.post<User>(this.baseUrl5, user);
  // }

  // //Get user by id
  // getUserById(id:number): Observable<User>{
  //   return this.http.get<User>(`${this.baseUrl5}/${id}`);
  // }

  // //Update user
  // updateUser(id: number, user: User): Observable<User>{
  //   return this.http.put<User>(`${this.baseUrl5}/${id}`, user);
  // }

  // //Delete user
  // deleteUser(id: number): Observable<void>{
  //   return this.http.delete<void>(`${this.baseUrl5}/${id}`);
  // }
  

  public login(loginData: any){
    return this.http.post(this.baseUrl6 + "/authenticate", loginData, {headers: this.requestHeader});
  }

  //public roleMatch(allowedRoles):boolean
  // public roleMatch(allowedRoles:string[]):Boolean{
  //   let isMatch = false;
  //   const userRoles:any= this.userAuthService.getRoles();

  //   if(userRoles != null && userRoles){
  //     for(let i=0; i< userRoles.length; i++){
  //       for(let j=0; j< allowedRoles.length; j++){

  //         if(userRoles[i].roleName === allowedRoles[j]){
  //           isMatch = true;
  //           return isMatch;
  //         }else {
  //           return isMatch;
  //         }

  //       }
  //     }
  //   }
  // }

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
