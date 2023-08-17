import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Payment} from 'src/model/payment.model';

//payment window
function _window() : any{
  return window;
}

@Injectable({
  providedIn: 'root'
})



export class PaymentService {

  private baseUrl4 = 'http://localhost:9613/cafe/payment';

  constructor(private http: HttpClient) { }

  //Process payment
  processPayment(payment: Payment): Observable<Payment>{
    return this.http.post<Payment>(this.baseUrl4, payment);
  } 

  //Get payment by id
  getPaymentById(id: string): Observable<Payment>{
    return this.http.get<Payment>(`${this.baseUrl4}/${id}`);
  }

  //Update payment status
  updatePaymentStatus(id: string, status: string): Observable<Payment>{
    return this.http.put<Payment>(`${this.baseUrl4}/${id}/status`,{status});
  }

  //Payment window
  get nativeWindow(): any{
    return _window();
  }
}
