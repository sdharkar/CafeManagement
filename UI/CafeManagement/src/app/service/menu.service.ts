import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MenuItem } from 'src/model/menu-item.model';
import { Order } from 'src/model/order.model';


@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private baseUrl1 = 'http://localhost:9610/api/menu/items';
  

  constructor(private http: HttpClient) { } 

  //Create MenuItem
  createMunuItem(menuItem: MenuItem):Observable<MenuItem>{
    return this.http.post<MenuItem>(this.baseUrl1, menuItem);
  }

  //Get MenuItem
  getMenuItem(): Observable<MenuItem[]>{
    return this.http.get<MenuItem[]>(this.baseUrl1);
  }

  //Get menu by id
  getMenuItemById(id: string): Observable<MenuItem>{
    return this.http.get<MenuItem>(`${this.baseUrl1}/${id}`)
  }

  //Update menuItem
  updateMenuItem(id: string, menuItem: MenuItem): Observable<MenuItem>{
    return this.http.put<MenuItem>(`${this.baseUrl1}/${id}`, menuItem);
  }

  //Delete menu item
  deleteMenuItem(id: string): Observable<void>{
    return this.http.delete<void>(`${this.baseUrl1}/${id}`);
  }

  addToCart(id: string): Observable<Order>{
    return this.http.get<Order>(`${this.baseUrl1}/cart/${id}`);
  }
  
}

