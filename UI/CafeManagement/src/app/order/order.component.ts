import { Component, OnInit } from '@angular/core';
import { Order } from 'src/model/order.model';
import { OrderService } from '../service/order.service';
import { MenuItem } from 'src/model/menu-item.model';
import { MenuService } from '../service/menu.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{
  menuItems: MenuItem[] = [];
  orders!: Order[];
  totalAmount: number = 0;

  constructor(private orderService: OrderService, private menuService: MenuService){}

  ngOnInit(): void {
      this.loadMenuItems();
  }

  //Display menu items
  loadMenuItems(){
    this.menuService.getMenuItem().subscribe( data =>{
      this.menuItems = data;
    },
    error => {
      console.error('Error loading menu items:', error);
    });
  }

  //Add menu item to order
  addToOrder(item:MenuItem){

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
