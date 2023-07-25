import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Payment} from 'src/model/payment.model'

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private baseUrl = 'http://localhost:9613/api/payment';

  constructor(private http: HttpClient) { }

  //Process payment
  processPayment(payment: Payment): Observable<Payment>{
    return this.http.post<Payment>(this.baseUrl, payment);
  } 

  //Get payment by id
  getPaymentById(id: string): Observable<Payment>{
    return this.http.get<Payment>('${this.baseUrl}/${id}');
  }

  //Update payment status
  updatePaymentStatus(id: string, status: string): Observable<Payment>{
    return this.http.put<Payment>('${this.baseUrl}/${id}/status',{status});
  }
}
