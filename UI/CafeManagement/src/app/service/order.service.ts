import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from 'src/model/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:9611/api/orders';

  constructor(private http: HttpClient) { }

  //Place order
  placeOrder(order: Order): Observable<Order>{
    return this.http.post<Order>(this.baseUrl, order);
  }

  // Get order by id
  getOrderById(id: string): Observable<Order>{
    return this.http.get<Order>(`${this.baseUrl}/${id}`);
  }

  //Get orders for user
  getOrdersForUsers(userId: string): Observable<Order[]>{
    return this.http.get<Order[]>("${this.baseUrl}/user/${userId}");
  }

  //Update order status
  updateOrderStatus(id: string, status: string): Observable<Order>{
    return this.http.put<Order>(`${this.baseUrl}/${id}/status`, { status });
  }

  //Cancel Order
  cancelOrder(id: string): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

}
