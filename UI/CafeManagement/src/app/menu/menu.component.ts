import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'src/model/menu-item.model';
import { MenuService } from '../service/menu.service';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from '../service/order.service';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent implements OnInit{

  menuItems!: MenuItem[];

  menuItem: MenuItem = new MenuItem();
  
  constructor(private menuService: MenuService, private activatedRoute: ActivatedRoute, private router: Router, private orderService: OrderService) {}

  ngOnInit(): void {
  this.loadMenuItems();
}

  loadMenuItems(): void{
    this.menuService.getMenuItem().subscribe(
      (items) => {
        this.menuItems = items;
      },
      (error) => {
        console.error('Error loading menu items:', error);
      }
    );
  }

  addToCart(id: string){
    this.menuService.addToCart(id).subscribe(response =>{
        console.log(response);
    },
    error => console.error("Error in adding to cart", error));
  }

}
