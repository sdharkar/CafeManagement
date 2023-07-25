import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { User } from 'src/model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:9614/api/user';

  constructor(private http: HttpClient) { }

  //Create user
  createUser(user: User): Observable<User>{
    return this.http.post<User>(this.baseUrl, user);
  }

  //Get user by id
  getUserById(id:number): Observable<User>{
    return this.http.get<User>('${this.baseUrl}/${id}');
  }

  //Update user
  updateUser(id: number, user: User): Observable<User>{
    return this.http.put<User>('${this.baseUrl}/${id}', user);
  }

  //Delete user
  deleteUser(id: number): Observable<void>{
    return this.http.delete<void>('${this.baseUrl}/${id}');
  }
  
}
