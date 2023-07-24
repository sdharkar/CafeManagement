import { Component } from '@angular/core';
import { Order } from 'src/model/order.model';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {

  orders: Order[] = [];

  constructor(private orderService: OrderService){
    this.loadOrdersForUser('user123');
  }

  loadOrdersForUser(userId: string): void {
    this.orderService.getOrdersForUsers(userId).subscribe(
      (orders) => {
        this.orders = orders;
      },
      (error) => {
        console.error('Error loading orders:', error);
      }
    );
  }

}
